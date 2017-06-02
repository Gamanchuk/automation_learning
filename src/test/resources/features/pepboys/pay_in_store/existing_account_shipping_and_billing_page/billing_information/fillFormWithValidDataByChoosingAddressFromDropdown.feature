@pepBoys

Feature: PAY IN STORE - EXISTING ACCOUNT - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16626")
  Scenario: Test with correct billing information and fill in all required fields (Choose address from drop-down)
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Customer Information" page
    And applies customer info for address "8th avenue, Unit 1611"
    And user checks customer info for "qa user3"

    And presses the "Place Order" button
    Then user should be on thank you page


