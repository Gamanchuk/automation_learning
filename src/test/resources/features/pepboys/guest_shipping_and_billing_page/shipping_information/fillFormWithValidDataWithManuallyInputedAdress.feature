@pepBoys

Feature: GUEST - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5848")
  @TestCaseId("15374")
  Scenario: Test with correct shipping information and fill in all required fields (Address input manually)
    Given user types manually billing info for "qa user"
    And user types manually shipping info for "qa user"
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery Method" tab
    Then user checks shipping info for "qa user"


