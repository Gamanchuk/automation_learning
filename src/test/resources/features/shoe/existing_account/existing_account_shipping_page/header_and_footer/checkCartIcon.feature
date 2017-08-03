@shoe

Feature: EXISTING ACCOUNT - SHIPPING PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab

  @TestCaseId("16743")
  Scenario: Check Cart icon
    And user presses the Shopping Cart icon
    Then user should be on Shoe cart page