@pepBoys @debug1


Feature: Header and Footer (Pay Online)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15398")
  Scenario: Tap on icon Shopping Cart navigate to shopping cart page (Guest, Pay Online, Payment Method tab)
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment
    And user presses the Shopping Cart icon
    Then user should be on cart page