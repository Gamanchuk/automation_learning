@qvc @debug

Feature: EXISTING ACCOUNT - PAYMENT PAGE

  Background:
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And presses the "Continue" button

  @TestCaseId("102274")
  Scenario: Edit Billing Information
    Given user should be on "Payment" tab
    And user clicks arrow for "Billing Address"
    And applies billing info for address "8th avenue, Unit 1611"
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    Then user should be on "Payment & Review" tab
    And user checks billing info for "qa user3"
