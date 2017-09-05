@philosophy

Feature: GUEST - SHIPPING PAGE - SHIPPING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest

  @TestCaseId("")
  Scenario: Test Pricing Totals with different shipping options

    Given chooses "FREE" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "visa" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab
    And user checks "FREE" shipping method

    And user navigates to "Shipping" breadcrumb

    Given chooses "UPS 2 Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And user fills "CVV" field from "visa" card
    And presses the "Continue" button
    Then user should be on "Review" tab
    And user checks "UPS 2 Days" shipping method

    And user navigates to "Shipping" breadcrumb

    Given chooses "UPS 1 Day" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And user fills "CVV" field from "visa" card
    And presses the "Continue" button
    Then user should be on "Review" tab
    And user checks "UPS 1 Day" shipping method