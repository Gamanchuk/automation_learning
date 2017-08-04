@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE - GIFT CARD

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment


  @TestCaseId("16825")
  Scenario: Test field "Gift Card" when user enter Valid Gift Card Account

    Given user types gift card with "6366740000012762997" number and "0285" pin code
    And presses the "Apply" button
    Then sees modal with title "gift card successfully applied!"
