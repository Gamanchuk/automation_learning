@qvc

Feature: EXISTING ACCOUNT - SHIPPING DETAILS PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    Then user should be on "Delivery" tab

  @Issue("MCCAT-6044")
  @TestCaseId("102306")
  Scenario: Test Shipping Information Modal

    Given user clicks "Shipping Information" link in note
    Then user should see Terms modal with "How will my order ship?"
