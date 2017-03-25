@pepBoys @refactoring


Feature: Happy Path

  Background:
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Pick Up in Store" delivery option
    And user adds to cart product with id "8536875" with "Ship to Home" delivery option
    And user adds to cart any tires with "Installation" delivery option for "captive"
    And user views cart
    And user schedules installation time
    And chooses "Pay Online" method with appointment details

  @TestCaseId("16252")
  Scenario: Place Multiple Orders as a "Guest"
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground" shipping method
    And uses "visa" card for payment
    Then user should be on thank you page
