@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal
    And user confirms purchase with PayPal
    And user should be on "Shipping" tab
    And user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab

  @TestCaseId("101204")
  Scenario: Check Cart Icon

    Given user presses the Shopping Cart icon
    Then user should be on Saatva cart page

