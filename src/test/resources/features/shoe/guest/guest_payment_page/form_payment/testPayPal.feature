@shoe @Ignored

Feature: GUEST - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    Then user should be on "Payment" tab

  @TestCaseId("16332")
  Scenario: Test alternate payment method: with Valid PayPal

    Given user chooses "PayPal" for payment
    Then presses the "Continue with PayPal" button
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal
    Then user should be on "Review" tab

