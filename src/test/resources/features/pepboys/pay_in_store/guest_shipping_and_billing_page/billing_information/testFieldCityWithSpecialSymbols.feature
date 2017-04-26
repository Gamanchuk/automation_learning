@pepBoys @debug

Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16647")
  Scenario: Test field 'City' with special symbols
    Given user types billing info for "qa user"
    And user types "!@$%^&*():_+" into the "City" field of "Billing Address" address form
    And presses the "Place Order" button
    Then user checks city info with value "!@$%^&*():_+" on thank you page



