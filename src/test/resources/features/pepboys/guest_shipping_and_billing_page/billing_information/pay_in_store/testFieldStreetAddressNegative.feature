@pepBoys


Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "9663189" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16645")
  Scenario: Test field 'Address Street' Negative
    Given user types billing info for "qa user"
    And user types "" into the "Street Address" field of "Billing Address" form
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."