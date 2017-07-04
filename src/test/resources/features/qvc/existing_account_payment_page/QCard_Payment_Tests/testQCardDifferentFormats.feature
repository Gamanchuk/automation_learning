@qvc

Feature: EXISTING ACCOUNT - PAYMENT PAGE - QCARD

  Background:
    Given user adds to cart product
    And user continue checkout as "qa user4"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And presses the "Continue" button

  @TestCaseId("102280")
  @Issue("MCCAT-6001")
  Scenario: Test QCard fields and format
    Given user should be on "Payment" tab
    And selects "Enter a New Card"
    And uses "qcard" card for payment

