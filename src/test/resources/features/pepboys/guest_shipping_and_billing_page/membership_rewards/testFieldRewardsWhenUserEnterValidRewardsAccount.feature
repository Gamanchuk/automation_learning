@pepBoys

Feature: GUEST - MEMBERSHIP REWARDS

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5848")
  @TestCaseId("15389")
  Scenario: Test field "Rewards" when user enter Valid Rewards Account
    Given user types billing info for "qa user"

    And user types rewards number for "qa user"
    And presses the "Continue" button

    And user should be on "Delivery Method" tab
    Then user checks shipping info for "qa user"


