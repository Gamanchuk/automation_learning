@pepBoys


Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15391")
  Scenario: Test checkbox "Don't have a reward number"
    Given user types billing info for "qa user"
    And user chooses don't have a reward number
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground: 5-7 Days" shipping method
    And uses "visa" card for payment
    And presses the "Place Order" button
    Then user should be on thank you page



