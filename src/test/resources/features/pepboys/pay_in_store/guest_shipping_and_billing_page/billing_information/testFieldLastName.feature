@pepBoys

Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16644")
  Scenario: Test field 'Last name'
    Given user types customer info for "qa user"
    And user types "Moovweb " into the "Full Name" field of "Customer Information" address form
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Moovweb !@#&::!@#()" into the "Full Name" field of "Customer Information" address form
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Last Name is invalid"








