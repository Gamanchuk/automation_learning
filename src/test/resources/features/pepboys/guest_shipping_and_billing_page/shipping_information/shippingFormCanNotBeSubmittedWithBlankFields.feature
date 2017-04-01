@pepBoys


Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15376")
  Scenario: Test with correct shipping information and do not fill in all required fields (error message should be displayed)
    Given user types billing info for "qa user"
    And unset checkbox "Yes, shipping address and billing address are the same"
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

