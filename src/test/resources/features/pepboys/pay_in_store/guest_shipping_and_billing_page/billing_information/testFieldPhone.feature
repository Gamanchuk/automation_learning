@pepBoys @debug

Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16650")
  Scenario: Test field 'Phone'
    Given user types customer info for "qa user"
    And user types "" into the "City" field of "Customer Information" address form
    And presses the "Continue" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "4152011234" into the "City" field of "Customer Information" address form
    And presses the "Place Order" button
    Then user checks phone with value "4152011234" on thank you page

