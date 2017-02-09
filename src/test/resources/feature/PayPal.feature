@testdiary1


Feature: Customer navigate to google.com

  @TestCaseId("15860")
  Scenario: Navigate to google
    Given the user go to page "http://google.com"

  @TestCaseId("15861")
  Scenario: Navigate to google v2
    Given the user go to page "http://google.com"
    Then assert "false"
