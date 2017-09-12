@philosophy

Feature: GUEST - DELIVERY PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest
    Then user should be on "Shipping" tab
    Given user types shipping info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And user can expand and collapse Order summary

  @TestCaseId("17224")
  @TestCaseId("82888")
  Scenario: Test delivery method page and delivery options

    And chooses "Ground" shipping method
    And chooses "Express" shipping method
    And chooses "Rush Delivery" shipping method
    
    And presses the "Continue" button
    Then user should be on "Payment" tab

