@saatva

Feature: SHIPPING PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product from Saatva
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    And presses the "Continue" button
    Then user should be on "Shipping" tab


  @TestCaseId("101063")
  Scenario: Check Cart Icon

    Given user presses the Shopping Cart icon
    Then user should be on Saatva cart page