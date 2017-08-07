@shoe

Feature: GUEST - PAYMENT PAGE - GIFT CARD

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    Then user should be on "Payment" tab


  @TestCaseId("16321")
  @TestCaseId("16334")
  Scenario: Test field "Gift Card" when user enter Valid Gift Card Account

    Given uses "mastercard" card for payment
    And user types gift card with "6366740000012762997" number and "0285" pin code
    And presses the "Apply" button
    Then sees modal with title "gift card successfully applied!"
