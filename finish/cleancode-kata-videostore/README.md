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
