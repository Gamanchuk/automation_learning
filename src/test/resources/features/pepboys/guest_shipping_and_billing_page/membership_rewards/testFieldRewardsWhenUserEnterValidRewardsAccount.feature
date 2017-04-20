@pepBoys


Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15389")
  Scenario: Test field "Rewards" when user enter Valid Rewards Account
    Given user types billing info for "qa user"
    And user types rewards number "990298322581"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And user should be on "Delivery Method" tab
    Then user checks shipping info for "qa user"


