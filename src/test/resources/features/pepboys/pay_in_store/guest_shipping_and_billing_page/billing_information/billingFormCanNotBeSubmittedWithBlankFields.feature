@pepBoys @debug

Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16642")
  Scenario: Test billing form with blank fields
    Given presses the "Continue" button
    Then user should be on "Customer Information" page
    And sees "FORM ERRORS" error message with text "Please review all inputs."

