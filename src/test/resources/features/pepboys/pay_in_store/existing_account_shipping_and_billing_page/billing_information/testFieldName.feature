@pepBoys

Feature: PAY IN STORE - EXISTING ACCOUNT - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16630")
  Scenario: Test field 'Name'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Customer Information" page
    And selects "Enter a New Address"
    And user types сustomer info for "qa user" and checks email

    And user types "" into the "Full Name" field of "Customer Information" address form
    And presses the "Place Order" button
    And user should be on "Customer Information" page
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#&( !@#()" into the "Full Name" field of "Customer Information" address form
    And presses the "Place Order" button
    And user should be on "Customer Information" page
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mr Donal Trump III" into the "Full Name" field of "Customer Information" address form
    And presses the "Place Order" button
    Then user should be on thank you page