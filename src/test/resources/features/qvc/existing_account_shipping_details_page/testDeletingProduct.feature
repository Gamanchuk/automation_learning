@qvc

Feature: EXISTING ACCOUNT - SHIPPING DETAILS PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    Then user should be on "Delivery" tab

  @Issue("MCCAT-6168")
  @TestCaseId("102305")
  Scenario: Test Deleting a product from Shipping Detail Page

    Given user remove product
    Then sees modal error with text "There are no items in your Shopping Cart. Please select the items you would like to purchase, and place your order."
    And presses the "Continue" button
    Then user should be on QVC cart page
    And user should be see error message on QVC cart page with text "There are no items in your Shopping Cart. Please select the items you would like to purchase, and place your order."