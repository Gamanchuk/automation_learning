@pepBoys @debug

Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16646")
  Scenario: Test field 'Apartment' with 2 words
    Given user types customer info for "qa user"
    And user types "Some Apartment" into the "Apt, Bldg." field of "Customer Information" address form
    And presses the "Place Order" button
    Then user checks "Apt, Bldg." with value "Some Apartment" on thank you page
