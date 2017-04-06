@pepBoys

Feature: Happy Path

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15403")
  Scenario: Test field "Card Number"
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground" shipping method
    And presses the "Continue" button

    And user clicks arrow for "Billing Address"
    And user types manually billing info for "qa user2"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground" shipping method
    And presses the "Continue" button
    And user checks billing info for "qa user2"
