@pepBoys @debug

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15413")
  Scenario: Test field "Card Number"
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    And user clicks arrow for "Billing Address"
    And user types manually billing info for "qa user2"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And user checks billing info for "qa user2"
