@pepBoys


Feature: Happy Path

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("16248")
  Scenario: Place Order as a "Registered User" with Credit Card
    Given user makes authorisation for "qa user"
    And applies billing info for address "201 SPEAR ST"
    And presses the "Continue" button
    And choice "Use Recommended Address"
    And chooses "Ground" shipping method
    And uses "visa" card for payment
    Then user should be on thank you page
