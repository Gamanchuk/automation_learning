@philosophy

Feature: GET STARTED PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy

  @TestCaseId("82807")
  Scenario: Check Cart icon

    Given user presses the Shopping Cart icon
    Then user should be on Philosophy cart page