@pepBoys

Feature: PAY IN STORE - EXISTING ACCOUNT - SHIPPING & BILLING PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16627")
  Scenario: Test with correct billing information and do not fill in all required fields (error message should be displayed)
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing Address" page
    And selects "Enter a New Address"
    And presses the "Place Order" button

    And user should be on "Billing Address" page
    And sees "FORM ERRORS" error message with text "Please review all inputs."

