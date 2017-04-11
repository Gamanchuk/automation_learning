@pepBoys

Feature: Happy Path

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("16247")
  Scenario: Place Order as a "Guest" with Credit Card
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    And uses "visa" card for payment
    And presses the "Place Order" button

    # TODO: Update this method after fixing issue with Place Order

    Then user should be on thank you page
