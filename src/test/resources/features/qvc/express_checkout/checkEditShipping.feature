@qvc

Feature: EXPRESS CHECKOUT

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user fills email field with "manytu3@i.ua"
    And presses the "Continue" button
    And user checks "Using your default shipping and payment information?" checkbox
    And user fills password field with "q1q1w1w1"
    And presses the "Continue" button
    Then user should be on "Review" tab


  @TestCaseId("")
  Scenario: Check Edit Shipping info

    And user clicks arrow for "Shipping Address"
    And user should be on "Address" tab
    And unset checkbox "Yes, shipping address and billing address are the same"
    And applies shipping info for address "QAMOOVWEB17: 123 Mission St, 10"
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And presses the "Continue" button

    And user should be on "Payment" tab
    And uses saved "visa" card for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    And user checks shipping info for "qa user"
    And presses the "Place Order" button

    Then user should be on thank you page