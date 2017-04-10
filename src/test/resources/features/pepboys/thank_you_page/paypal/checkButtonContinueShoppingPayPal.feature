@pepBoys @debug

Feature: PayPal - Thank You Page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "PayPal" method


  @TestCaseId("15569")
  Scenario: Check button Continue Shopping (Guest, PayPal)
    Given user confirms purchase as "qa user" with PayPal
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And checks payment details for "qa user"
    And presses the "Place Order" button
    And user should be on thank you page
    Then presses the "Continue Shopping" button
    And user should be on main page
