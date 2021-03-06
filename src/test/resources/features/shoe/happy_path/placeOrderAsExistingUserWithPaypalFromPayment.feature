@shoe

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe


  @TestCaseId("16269")
  Scenario: Place order with Paypal from payment as Existing user

    Given user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And user chooses "PayPal" for payment
    And  presses the "Continue with PayPal" button
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal
    Then user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page
