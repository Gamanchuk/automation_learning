@pepBoys @debug1


Feature: Header and Footer (Pay Online)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15371")
  Scenario: Tap on icon Shopping Cart navigate to shopping cart page (Guest, Pay Online, Billing & Shipping tab)
    Given user presses the Shopping Cart icon
    Then user should be on cart page