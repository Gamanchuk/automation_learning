@pepBoys, @refactoring


Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15495")
  Scenario: Test billing form with blank fields (error message should be displayed)
    Given presses the "Continue" button
    Then user stays at "Billing & Shipping" tab
    And sees "Form Errors" error message with text "Please review all inputs."

