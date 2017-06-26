@qvc

Feature: GUEST - SHIPPING DETAILS PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart "4" products
    And user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    Then user types billing info for "qa user" without email
    And presses the "Continue" button

  @TestCaseId("102355")
  Scenario: Test Multiple Product at Shipping Details Page

    Given user should be on "Delivery" tab
    Then user should see "4" products
