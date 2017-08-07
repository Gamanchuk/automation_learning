@shoe

Feature: EXISTING ACCOUNT - SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab

  @TestCaseId("16760")
  Scenario: Test Pricing Totals with different shipping options

    Given chooses "4-7 Business Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses saved "visa" card for payment
    And user fills "CVV" field from "visa" card
    And presses the "Continue" button
    Then user should be on "Review" tab
    And user checks "4-7 Business Days" shipping method

    And user navigates to "Shipping" breadcrumb

    Given chooses "2nd Business Day" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And user fills "CVV" field from "visa" card
    And presses the "Continue" button
    Then user should be on "Review" tab
    And user checks "2nd Business Day" shipping method

    And user navigates to "Shipping" breadcrumb

    Given chooses "Next Business Day" shipping method
    And presses the "Continue" button
    And user should be on "Payment" tab
    And user fills "CVV" field from "visa" card
    And presses the "Continue" button
    Then user should be on "Review" tab
    And user checks "Next Business Day" shipping method