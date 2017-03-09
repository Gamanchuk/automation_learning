@pepBoys

Feature: Some feature

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("16247")
  Scenario: Place Order as a "Guest" with Credit Card
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Ground" shipping method
    And uses "visa" card for payment
    Then user should be on thank you page
