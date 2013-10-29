Feature: Test logger formatter

Background: Unit tests are already logging via SLF4J
Given that the Cucumber tests are run in the same CI server
  And the logging is set up correctly
  
Scenario:
Given that a logger has been installed
When Cucumber executes
Then stuff is logged
