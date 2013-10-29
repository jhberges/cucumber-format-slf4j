Feature: Test logger formatter

Background: Unit tests are already logging via SLF4J
Given that the Cucumber tests are run in the same CI server
  And the logging is set up correctly
  
Scenario: Just a bit o' logging
Given that a logger has been installed
And that theres data
| col1 | col2 |
| A    | 1234 |
When Cucumber executes
Then stuff is logged

Scenario Outline: Tables tables
 Given some <value>
  When "stuff" happens
  Then Aliens
  
  Examples:
  | value|
  |  1   |
  |  2   |