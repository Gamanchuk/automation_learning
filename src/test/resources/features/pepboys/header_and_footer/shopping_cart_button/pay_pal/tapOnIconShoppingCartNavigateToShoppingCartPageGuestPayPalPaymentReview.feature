@pepBoys


Feature: Header and Footer (PayPal)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "PayPal" method


  @TestCaseId("15563")
  Scenario: Tap on icon Shopping Cart navigate to shopping cart page (Guest, PayPal, Payment & Review tab)
    Given user confirms purchase as "qa user" with PayPal
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And checks payment details for "qa user"
    And user presses the Shopping Cart icon
    Then user should be on cart page

