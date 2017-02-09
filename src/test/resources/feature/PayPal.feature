@testdiary1


Feature: Customer navigate to google.com

  Scenario: Navigate to google
    Given the user go to page "http://google.com"

  Scenario: Navigate to google v2
    Given the user go to page "http://google.com"
    Then assert "false"
