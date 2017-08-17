@philosophy

Feature: GET STARTED PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy


  @TestCaseId("82846")
  Scenario: Checkout as guest

    Given user continue checkout as guest
    Then user should be on "Shipping" tab
