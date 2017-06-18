@qvc

Feature: GUEST - SHIPPING DETAILS PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102353")
  Scenario: Test Deleting a product from Shipping Detail Page

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types billing info for "qa user" without email
    And presses the "Continue" button

    And user remove product
    Then sees modal error with text "There are no items in your Shopping Cart. Please select the items you would like to purchase, and place your order."

