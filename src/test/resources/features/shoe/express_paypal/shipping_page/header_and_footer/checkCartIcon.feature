@shoe

Feature: EXPRESS PAYPAL - SHIPPING PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart with PayPal checkout from Shoe
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal
    Then user should be on "Shipping" tab

  @TestCaseId("16534")
  Scenario: Check Cart icon

    Given user presses the Shopping Cart icon
    Then user should be on Shoe cart page