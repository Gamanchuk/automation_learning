@pepBoys

Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15494")
  Scenario: Test with correct shipping information and fill in all existing fields (Address chosen from dropdown of auto-detect)
    Given user types billing info for "qa user"
    And user types shipping info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    Then user checks billing info for "qa user"


