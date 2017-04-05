@pepBoys

Feature: Happy Path

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15400")
  Scenario: Test with correct Visa billing information and fill in all required fields
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground" shipping method
    And presses the "Continue" button

    And uses "visa" card for payment
    And presses the "Place Order" button
    Then user should be on thank you page

