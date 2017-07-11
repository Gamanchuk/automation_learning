@saatva

Feature: CONTACT PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product from Saatva

  @TestCaseId("101047")
  Scenario: Check Cart Icon

    Given user presses the Shopping Cart icon
    Then user should be on Saatva cart page

