@pepBoys

Feature: GUEST - SHIPPING & BILLING PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15371")
  Scenario: Check Cart icon
    Given user presses the Shopping Cart icon
    Then user should be on cart page