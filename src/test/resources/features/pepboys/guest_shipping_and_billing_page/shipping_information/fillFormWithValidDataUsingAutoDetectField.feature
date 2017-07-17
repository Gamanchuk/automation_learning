@pepBoys

Feature: GUEST - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5848")
  @TestCaseId("15375")
  Scenario: Test with correct shipping information and fill in all existing fields (Address chosen from dropdown of auto-detect)
    Given user types billing info for "qa user"
    And user types shipping info for "qa user" without email, phone
    And presses the "Continue" button
    Then user checks shipping info for "qa user"



