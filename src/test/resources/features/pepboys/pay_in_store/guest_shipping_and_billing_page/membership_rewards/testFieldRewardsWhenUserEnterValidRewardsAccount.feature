@pepBoys

Feature: PAY IN STORE - GUEST - MEMBERSHIP REWARDS

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16656")
  Scenario: Test field "Rewards" when user enter Valid Rewards Account
    Given user types billing info for "qa user"
    And user types rewards number "990298322581"
    And presses the "Place Order" button
    Then user should be on thank you page

