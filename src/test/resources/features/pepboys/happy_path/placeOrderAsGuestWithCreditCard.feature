@pepBoys

Feature: HAPPY PATH

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5505")
  @TestCaseId("16247")
  Scenario: Place Order as a "Guest" with Credit Card
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment
    And presses the "Place Order" button
    Then user should be on thank you page
