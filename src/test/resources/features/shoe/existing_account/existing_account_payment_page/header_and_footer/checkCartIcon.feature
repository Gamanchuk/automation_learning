@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab

  @TestCaseId("16794")
  Scenario: Check Cart icon
    And user presses the Shopping Cart icon
    Then user should be on Shoe cart page