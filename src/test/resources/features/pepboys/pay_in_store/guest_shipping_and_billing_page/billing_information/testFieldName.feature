@pepBoys

Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "9983690" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16643")
  Scenario: Test field 'Name'
    Given user types billing info for "qa user"
    And user types "" into the "Full Name" field of "Billing Address" address form
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#&( !@#()" into the "Full Name" field of "Billing Address" address form
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mr Donal Trump III" into the "Full Name" field of "Billing Address" address form
    And presses the "Place Order" button
    And chooses "Use Entered Address"
    Then user should be on thank you page
    And user checks "Full Name" with value "Mr Donal Trump III" on thank you page
