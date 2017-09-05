@philosophy

Feature: GET SHIPPING PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest

  @TestCaseId("17110")
  Scenario: Check Cart icon

    Given user presses the Shopping Cart icon
    Then user should be on Philosophy cart page