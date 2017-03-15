@pepBoys


Feature: Happy Path

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Pick Up in Store" delivery option
    And user adds to cart product with id "8536851" with "Ship to Home" delivery option
    And user adds to cart any tires with "Installation" delivery option for "captiva"
    And user views cart
    And user schedule installation time
    And chooses "Pay Online" method with appointment details

  @TestCaseId("16253")
  Scenario: Place Multiple Orders as exist user
    Given user makes authorisation for "qa user"
    And applies billing info for address "201 SPEAR ST"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground" shipping method
    And uses "visa" card for payment
    Then user should be on thank you page
