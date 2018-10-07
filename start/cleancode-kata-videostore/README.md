# Clean Code Kata - VideoStore

Code used to demonstrate in a workshop how clean code principles can be
applied to existing legacy code.

Observe

- Very old code like written by C++ programmer
- Variables in some classes are placed at bottom
- Test class has long lines which make us scroll horizontally right
- Yuck
- Tests pass

Activity

- Break the strings in the test methods into multiple parts
- Makes methods visible all in one screen
- No scrolling to right needed

Observe

- all test methods are testing UI that is actual report
- all they need to test is the amounts calculated
- UI string test can be there in one of the tests for completeness
- repetition of UI strings introduce regression impact

Activity

- move all variables in all classes to top
- add assertions with code as below
    ```java
    assertEquals(9.0, customer.getTotal(), DELTA);
    assertEquals(2, customer.getFrequentRenterPoints());
    ```
- create the necessary methods required with IDE intellisense
- promote variables totalAmount and frequentRenterPoints to fields, keep init in current method


Activity

- Remove the string comparison in first test
- Just execute `customer.statement();` statement to generate them

Observe

- Customer class is just generating a statement
- It has nothing to do with a customer other than
- maintaining a variable of Customer customerName

Activity

- Rename Customer class to Statement
- Rename customerName in Statement class to customerName
- Rename statement method to generate
- Change all test methods to assert calculated values
- Duplicate last test to maintain one of them as testing string
- Add suffix format to the last method
- Add suffix Totals to all other test methods
- Keep the string comparison as is in last method

Activity 

- Change Fred to Customer in customer name
- Change the format method to reflect this change
- extract field for `new Movie("The Cell", Movie.NEW_RELEASE)` with name newReleaseMovie1
- extract `new Movie("The Tigger Movie", Movie.NEW_RELEASE)` into field newReleaseMovie2
- change title of `The Cell` to `New Release 1`
- change title of `The Tiger Movie` to `New Release 2`
- change all movies to variables and titles to generic titles
- change the format method to reflect the changes

Activity

- generate method of the Statement class
- extract the statements which initialize to method 
    ```java
    totalAmount = 0;
    frequentRenterPoints = 0;
    ```
- Rename result variable to statementText
- extract method for createHeader
- Change return value of createHeader to `String.format`

Observe

- for loop in the generate method
- just adds rental lines to the statement
- extract for loop in method named createRentalLines
- remove the params and eliminate side effects

Activity

- rename statementText to rentalLinesText in createRentalLines method
- combine footer test strings and format to multiple lines
- extract footer logic to createFooter
- rename initialize method to clearTotals
- change return value in createFooter to `String.format`
- check test failures and correct format of float

Activity

- Change the order of methods in order of calls
- Step down method of ordering methods
- remove unused getCustomerName method
- Extract body of for loop from method createRentalLines to method named createRentalLine
- rename variable rentalLinesText to rentalLineText in method createRentalLine

Activity

- extract the switch statement into method using comment content for name
- do not pass thisAmount variable
- Rename variable thisAmount to rentalAmount in method determineAmount and createRentalLine
- Extract frequentRenterPoints login into method determineFrequentRenterPoints
- Modify method to make it simpler and return value without side effect

Activity

- extract condition in determineFrequentRenterPoints method
- into a variable
- name it bonusIsEarned
- rearrange all calculations at top in createRentalLine
- extract formatting of rental lines into method formatRentalLines
- remove variable declaration
- change return value to `String.format` call
- inline variable for createRentalLine method return value

Activity

- Remove demeter law violation for `rental.getMovie().getTitle()`
- In method formatRentalLines
- Making method call like `rental.getTitle()`
- Rearrange methods of Statement class for step down method

Observe

- determineAmount method is not cohesive
- it does not uses any fields in statement class
- it does not belong to Statement class
- in fact it should belong to Rental class as it uses methods from that class
- same true with method determineFrequentRenterPoints

Activity 

- Move the method determineAmount to Rental class as public
- change calls to getMovie() and getDaysRented() to field variables
- Move determineFrequentRenterPoints method to Rental class
- change calls to getMovie() and getDaysRented() to field variables

Observe

- In Rental class determineAmount
- We use four things from movie and only one thing fro Rental
- this method hence belongs to Movie class
- same with method determineFrequentRenterPoints

Activity

- Add signatures of method like follows
    ```java
    public double determineAmount() {
        return determineAmount(daysRented);
    }

    public double determineAmount(int daysRented) {
    ```
- Move the method with argument to Movie class
- Fix the rental this issue
- Same Move with determineFrequentRenterPoints method to Movie

Activity

- Inline priceCode in both methods

Observe

- determineAmount in Movie is using switch
- it should use polymorphic dispatch
- we have to do this without breaking code

Activity

- In Test class
- Change the Movie class names to sub classes to create them with IDE
- remove the second parameter from constructors as it is redundant now
- In Movie class for determineAmount method
- use refactoring Push Members Down, keep in Movie as abstract
- Run with coverage and remove unused code from all subclasses
- Remove the type codes of Movies now as they are redundant
- Change signature of constructor of Movie and remove priceCode
