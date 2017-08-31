@shoe @debug

Feature: EXPRESS PAYPAL - REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart with PayPal checkout from Shoe
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal
    Then user should be on "Shipping" tab
    And presses the "Continue" button


  @TestCaseId("16524")
  Scenario: Order summary has functionality to expand and collapse

    Given user should be on "Review" tab
    Then user can expand and collapse Order summary