@pepBoys @debug

Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16645")
  Scenario: Test field 'Address Street'
    Given user types billing info for "qa user"
    And user types "" into the "Street Address" field of "Billing Address" address form
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mission Street" into the "Street Address" field of "Billing Address" address form
    And presses the "Place Order" button
    Then user checks "Street Address" with value "Mission Street" on thank you page
