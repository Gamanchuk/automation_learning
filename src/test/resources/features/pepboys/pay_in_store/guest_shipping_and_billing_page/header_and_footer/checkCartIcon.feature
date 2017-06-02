@pepBoys


Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16696")
  Scenario: Check Cart icon
    Given user presses the Shopping Cart icon
    Then user should be on cart page