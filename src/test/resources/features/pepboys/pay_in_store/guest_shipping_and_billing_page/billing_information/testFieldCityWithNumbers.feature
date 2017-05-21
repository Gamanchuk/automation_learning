@pepBoys

Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16647")
  Scenario: Test field 'City' with numbers
    Given user types customer info for "qa user"
    And user types "123456" into the "City" field of "Customer Information" address form
    And presses the "Place Order" button
    Then user checks city info with value "123456" on thank you page


