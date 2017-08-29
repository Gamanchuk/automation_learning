@shoe

Feature: EXPRESS PAYPAL

  Background: Add product to card and process to checkout
    Given user adds product to cart with PayPal checkout from Shoe


  @TestCaseId("16520")
  Scenario: Accept information from paypal (email, shipping address, payment information)

    Given user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal
    Then user should be on "Shipping" tab
    And user remembered shipping info on "Shipping" tab
    And user remembered delivery method on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Review" tab

    And user checks shipping info on "Review" tab
    And user checks delivery method on "Review" tab

