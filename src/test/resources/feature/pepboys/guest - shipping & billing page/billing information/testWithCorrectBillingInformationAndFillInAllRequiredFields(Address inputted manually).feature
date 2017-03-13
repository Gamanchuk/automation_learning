@pepBoys, @debug


Feature: Some feature

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15493")
  Scenario: Test with correct billing information and fill in all required fields (Address inputted manually)
    Given user types manually billing info for "qa user"
    And presses the "Continue" button
    And choice "Use Entered Address"
    Then user check billing info for "qa user"


