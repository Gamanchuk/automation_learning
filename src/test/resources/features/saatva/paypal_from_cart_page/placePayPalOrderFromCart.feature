@saatva

Feature: EXPRESS PAYPAL CHECKOUT

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab
    And user types "4152011234" into the "Phone Number" field of "Shipping Address" address form
    And presses the "Continue" button


  @TestCaseId("101857")
  @TestCaseId("102544")
  @TestCaseId("102545")
  Scenario: Place order as guest with PayPal Express from cart page
    Given user should be on "Payment & Review" tab

    Then presses the "Place Order" button
    Then user should be on thank you page

