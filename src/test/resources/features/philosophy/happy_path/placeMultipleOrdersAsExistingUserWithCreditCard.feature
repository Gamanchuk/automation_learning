@philosophy @debug

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds products to cart "4" from Philosophy
    And chooses "Checkout" method from Philosophy
    And user makes authorisation for "qa user"

  @TestCaseId("17098")
  Scenario: Place multiple order as existing user with Credit Card

    Given user should be on "Shipping" tab
    And presses the "Continue" button

    Then user should be on "Delivery" tab
    And presses the "Continue" button

    Then user should be on "Payment" tab
    And uses saved "visa" card for payment
    And presses the "Continue" button

    Then user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page
