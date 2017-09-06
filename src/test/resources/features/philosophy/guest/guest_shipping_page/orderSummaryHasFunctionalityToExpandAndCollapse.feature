@philosophy

Feature: GUEST - SHIPPING PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest

  @TestCaseId("82936")
  Scenario: Order summary has functionality to expand and collapse
    Given user should be on "Shipping" tab
    Then user can expand and collapse Order summary