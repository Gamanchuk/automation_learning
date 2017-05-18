@pepBoys @debug

Feature: PAY IN STORE - EXISTING ACCOUNT - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16632")
  Scenario: Test field 'Address Street'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Customer Information" page
    And selects "Enter a New Address"
    And user types сustomer info for "qa user" and checks email

    And user types "!@$%^&*():_+" into the "Street Address" field of "Customer Information" address form
    And presses the "Place Order" button
    And chooses "Use Entered Address"
    Then user should be on thank you page
