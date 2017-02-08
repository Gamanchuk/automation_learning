@testdiary1


Feature: Customer navigate to google.com

  Scenario: Passed
    Given the user go to page "http://google.com"

  Scenario: Failed
    Given the user go to page "http://google.com"
    Then assert "false"
