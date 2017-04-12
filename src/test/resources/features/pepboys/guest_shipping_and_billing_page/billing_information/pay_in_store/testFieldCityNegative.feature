@pepBoys @debug

Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "627470" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16647")
  Scenario: Test field 'City' (Negative)
    Given user types billing info for "qa user"
    And user types "" into the "City" field of "Billing Address" form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And sees "FORM ERRORS" error message with text "Please review all inputs."


