@shoe

Feature: SIGN IN PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe

  @TestCaseId("16424")
  Scenario: Check Cart icon
    Given user presses the signIn button
    And user presses the Shopping Cart icon
    Then user should be on Shoe cart page