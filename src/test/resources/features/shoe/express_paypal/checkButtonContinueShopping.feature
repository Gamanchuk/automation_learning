@shoe

Feature: EXPRESS PAYPAL - ORDER REVIEW PAGE - THANK YOU PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart with PayPal checkout from Shoe
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page

  @TestCaseId("16541")
  @TestCaseId("16542")
  @TestCaseId("16543")
  @TestCaseId("16545")
  Scenario: Check button Continue Shopping

    Given presses the "Continue Shopping" button
    Then user should be on Shoe main page
