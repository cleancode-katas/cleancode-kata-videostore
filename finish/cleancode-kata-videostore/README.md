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


