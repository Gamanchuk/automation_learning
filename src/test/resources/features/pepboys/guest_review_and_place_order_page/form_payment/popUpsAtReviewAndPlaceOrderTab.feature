@pepBoys

Feature: Happy Path

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15411")
  Scenario: Test field "Card Number"
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground" shipping method
    And presses the "Continue" button

    And user clicks Terms link
    Then user should see Terms modal with "APPLICABLE LAW AND ARBITRATION AGREEMENT"
