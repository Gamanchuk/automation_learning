@pepBoys


Feature: Happy Path

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "PayPal" method
    And user confirms purchase as "qa user" with PayPal
    
  @TestCaseId("16249")
  Scenario: Place Order with Paypal from Shopping cart page
    And chooses "Ground" shipping method
    And presses the "Continue" button
    And checks payment details for "qa user"
    And presses the "Place Order" button
    Then user should be on thank you page