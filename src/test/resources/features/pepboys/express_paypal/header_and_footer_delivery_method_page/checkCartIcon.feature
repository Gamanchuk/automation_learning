@pepBoys

Feature: EXPRESS PAYPAL - DELIVERY METHOD PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "PayPal" method


  @TestCaseId("15558")
  Scenario: Check Cart icon
    Given user confirms purchase as "qa user" with PayPal
    And chooses "Ground: 5-7 Days" shipping method
    And user presses the Shopping Cart icon
    Then user should be on cart page