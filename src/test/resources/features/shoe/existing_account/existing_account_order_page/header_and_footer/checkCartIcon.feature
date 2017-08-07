@shoe

Feature: EXISTING ACCOUNT - ORDER REVIEW PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment
    And user fills "CVV" field from "visa" card
    And presses the "Continue" button
    Then user should be on "Review" tab

  @TestCaseId("16836")
  Scenario: Check Cart icon

    Given user presses the Shopping Cart icon
    Then user should be on Shoe cart page