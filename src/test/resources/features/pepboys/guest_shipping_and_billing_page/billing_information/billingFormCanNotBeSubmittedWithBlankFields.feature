@pepBoys

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15495")
  Scenario: Test with do not fill in all required fields
    Given presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

