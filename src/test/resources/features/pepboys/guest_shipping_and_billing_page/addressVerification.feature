@pepBoys


Feature: Happy Path

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("")
  Scenario: Check Address verification
    Given user types manually billing info for "qa user"
    And presses the "Continue" button
    And chooses "Edit Address"
    Then user should stay at "Billing & Shipping" tab