@pepBoys

Feature: PAY IN STORE - EXISTING ACCOUNT - SHIPPING & BILLING PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16634")
  Scenario: Test field 'City' with numbers
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing Address" page
    And selects "Enter a New Address"
    And user types billing info for "qa user" and checks email

    And user types "123456" into the "City" field of "Billing Address" address form
    And presses the "Place Order" button
    And chooses "Use Entered Address"
    Then user should be on thank you page