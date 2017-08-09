@shoe @debug

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds product to cart with Pick up in store from Shoe
    Then user should be on "Shipping" tab

  @TestCaseId("16271")
  Scenario: Place order that must be Pick up in store as guest


    Given user navigates to "Pick up in Store" tab

    And user fills find store field with "10020"
    And presses the "Search" button
    Then user should be see Store results
    And user selects random store
    And user fill contact details as "qa user"

    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses "mastercard" card for payment
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page
