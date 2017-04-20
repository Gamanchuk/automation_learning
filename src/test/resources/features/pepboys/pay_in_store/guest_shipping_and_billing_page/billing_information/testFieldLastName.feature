@pepBoys 


Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "832661" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16644")
  Scenario: Test field 'Last name'
    Given user types billing info for "qa user"
    And user types "Moovweb " into the "Full Name" field of "Billing Address" address form
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Moovweb !@#&::!@#()" into the "Full Name" field of "Billing Address" address form
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Last Name is invalid"








