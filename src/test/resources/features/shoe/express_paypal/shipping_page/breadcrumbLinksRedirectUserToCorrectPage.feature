@shoe

Feature: EXPRESS PAYPAL - SHIPPING PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart with PayPal checkout from Shoe
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal
    Then user should be on "Shipping" tab

  @TestCaseId("16273")
  Scenario: Breadcrumb links redirect user to correct page

    Given user presses "Review" breadcrumb tab
    Then user should stay at "Shipping" tab

    And presses the "Continue" button
    Then user should be on "Review" tab

    And user presses "Shipping" breadcrumb tab
    Then user should be on "Shipping" tab