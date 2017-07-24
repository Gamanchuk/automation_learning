@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal
    And user confirms purchase with PayPal
    And user should be on "Shipping" tab

  @TestCaseId("101865")
  Scenario: Check Cart Icon

    Given user presses the Shopping Cart icon
    Then user should be on Saatva cart page

