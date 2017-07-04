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
  Scenario: Check Edit Payment information

    Given user clicks arrow for "Payment Method"
    Then user should be on "Payment" tab

    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page