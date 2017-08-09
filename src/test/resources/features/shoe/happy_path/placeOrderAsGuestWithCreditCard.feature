@shoe @debug

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe

  @TestCaseId("16266")
  Scenario: Place order as guest with Credit Card

    Given user types shipping info for "qa user"
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses "mastercard" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page
