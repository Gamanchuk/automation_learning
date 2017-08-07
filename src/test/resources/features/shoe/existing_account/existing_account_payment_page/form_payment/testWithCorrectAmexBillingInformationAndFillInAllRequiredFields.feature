@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And selects "Enter a New Card"

  @TestCaseId("16796")
  Scenario: Test with correct Amex billing information

    Given uses "american express" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab