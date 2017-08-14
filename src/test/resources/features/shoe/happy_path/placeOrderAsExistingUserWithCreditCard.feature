@shoe

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe

  @TestCaseId("16267")
  Scenario: Place order as existing user with Credit Card

    Given user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page
