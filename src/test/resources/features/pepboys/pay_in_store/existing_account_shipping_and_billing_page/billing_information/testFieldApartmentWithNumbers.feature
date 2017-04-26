@pepBoys

Feature: PAY IN STORE - EXISTING ACCOUNT - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16633")
  Scenario: Test field 'Apartment' with numbers
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing Address" page
    And selects "Enter a New Address"
    And user types billing info for "qa user" and checks email

    And user types "12345" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Place Order" button
    Then user should be on thank you page
    And user checks "Apt, Bldg." with value "12345" on thank you page