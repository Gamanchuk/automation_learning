@pepBoys

Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16649")
  Scenario: Test field 'Zip Code'
    Given user types customer info for "qa user"
    And user types "" into the "City" field of "Customer Information" address form
    And presses the "Continue" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "94105" into the "City" field of "Customer Information" address form
    And presses the "Place Order" button
    And user checks zip code with value "94105" on thank you page
