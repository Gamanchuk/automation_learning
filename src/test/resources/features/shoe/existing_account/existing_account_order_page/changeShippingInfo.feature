@shoe

Feature: EXISTING ACCOUNT - ORDER REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And applies shipping info for address "123 Mission St"
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab

  @TestCaseId("16830")
  Scenario: Change shipping address

    Given user clicks arrow for "Shipping Address"
    And user should be on "Shipping" tab
    And applies shipping info for address "201 Spear St"
    And presses the "Continue" button
    Then user should be on "Payment" tab

    And uses saved "visa" card for payment
    And user fills "CVV" field from "visa" card
    And presses the "Continue" button
    Then user should be on "Review" tab




