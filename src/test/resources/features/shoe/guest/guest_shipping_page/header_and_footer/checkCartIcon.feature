@shoe

Feature: GUEST - SHIPPING PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe

  @TestCaseId("16385")
  Scenario: Check Cart icon

    Given user presses the Shopping Cart icon
    Then user should be on Shoe cart page