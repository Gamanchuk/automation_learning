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

  @TestCaseId("102302")
  @TestCaseId("102303")
  @Issue("MCCAT-5505")
  Scenario: Thank You page should be load and has all information
    Given user should be on "Payment" tab
    And selects "Enter a New Card"
    And uses "visa" card for payment
    And presses the "Place Order" button
    Then user should be on thank you page
