@pepBoys

Feature: EXISTING ACCOUNT - PAYMENT PAGE

  Background:
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And presses the "Continue" button

  @TestCaseId("102280")
  @Issue("MCCAT-5505")
  Scenario: Test with correct Visa billing information and fill in all required fields
    Given user should be on "Payment" tab
    And selects "Enter a New Card"
    And uses "qcard" card for payment
    And presses the "Place Order" button
    Then user should be on thank you page
