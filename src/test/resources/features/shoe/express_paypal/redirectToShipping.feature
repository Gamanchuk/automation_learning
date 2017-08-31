@shoe

Feature: EXPRESS PAYPAL

  Background: Add product to card and process to checkout
    Given user adds product to cart with PayPal checkout from Shoe


  @TestCaseId("16519")
  Scenario: Redirect to Shipping with Delivery info

    Given user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal
    Then user should be on "Shipping" tab
    And chooses "UPS 2 Days" shipping method