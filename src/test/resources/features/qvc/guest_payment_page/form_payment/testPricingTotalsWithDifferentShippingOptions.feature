@qvc @Ignored

Feature: GUEST - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102341")
  Scenario: Test Pricing Totals with different shipping options
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types manually billing info for "qa user" without email
    And presses the "Continue" button

    And chooses "UPS Ground" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "UPS Ground" shipping method
    And user navigates to "Delivery" breadcrumb

    And chooses "US Mail" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "US Mail" shipping method
    And user navigates to "Delivery" breadcrumb

    And chooses "Standard Delivery" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "Standard Delivery" shipping method
    And user navigates to "Delivery" breadcrumb

    And chooses "Priority US Mail" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "Priority US Mail" shipping method
    And user navigates to "Delivery" breadcrumb

    And chooses "UPS Express" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "UPS Express (Blue)" shipping method
    And user navigates to "Delivery" breadcrumb

    And chooses "Express Delivery" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "Express Delivery" shipping method
    And user navigates to "Delivery" breadcrumb

    And chooses "Premium Delivery" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "Premium Delivery" shipping method
    And user navigates to "Delivery" breadcrumb

    And chooses "UPS Premium" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "UPS Premium" shipping method






