@qvc

Feature: GUEST - SHIPPING DETAILS PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart "4" products
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab


  @TestCaseId("102307")
  Scenario: Test Deleting a product from Shipping Detail Page

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types billing info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Delivery" tab