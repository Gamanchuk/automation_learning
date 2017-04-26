@pepBoys

Feature: EXPRESS PAYPAL - THANK YOU PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "PayPal" method


  @TestCaseId("15569")
  @TestCaseId("15567")
  Scenario: Check button Continue Shopping
    Given user confirms purchase as "qa user" with PayPal
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And checks payment details for "qa user"
    And presses the "Place Order" button
    And user should be on thank you page
    Then presses the "Continue Shopping" button
    And user should be on main page