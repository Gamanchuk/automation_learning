@pepBoys

Feature: HAPPY PATH

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16254")
  Scenario: Place order that must be pay in store
    Given user types customer info for "qa user"
    And presses the "Place Order" button
    Then user should be on thank you page
