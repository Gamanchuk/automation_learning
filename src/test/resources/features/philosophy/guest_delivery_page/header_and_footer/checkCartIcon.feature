@philosophy

Feature: GUEST - DELIVERY PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest
    Then user should be on "Shipping" tab

  @TestCaseId("17221")
  Scenario: Check cart icon

    Given user types shipping info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Delivery" tab

    Given user presses the Shopping Cart icon
    Then user should be on Philosophy cart page