@qvc

Feature: GUEST - SHIPPING DETAILS PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @Issue("MCCAT-6044")
  @TestCaseId("102354")
  Scenario: Test Shipping Information Modal

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types billing info for "qa user" without email
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And user clicks "Shipping Information" link in note
    And user should see Terms modal with "How will my order ship"

