@pepBoys  @refactoring


Feature: Happy Path

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("16250")
  Scenario: Place Order with Paypal from Payment page as Guest
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground" shipping method
    And presses the "Continue" button
    And uses PayPal for payment
    And user confirms purchase as "qa user" with PayPal
    Then user should be on thank you page

