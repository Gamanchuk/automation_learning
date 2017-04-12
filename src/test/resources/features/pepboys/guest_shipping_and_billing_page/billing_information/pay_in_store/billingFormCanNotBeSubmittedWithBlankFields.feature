@pepBoys @debug

Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "787226" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16642")
  Scenario: Test billing form with blank fields (error message should be displayed)
    Given presses the "Continue" button
    Then user should be on "Billing" page
    And sees "FORM ERRORS" error message with text "Please review all inputs."

