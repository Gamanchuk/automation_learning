@pepBoys

Feature: EXISTING ACCOUNT - MEMBERSHIP REWARDS

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15443")
  Scenario: Tooltip of ID reward account must be present
    Given user makes authorisation for "qa user"
    And user should be on "Billing & Shipping" tab
    Then user checks rewards number for "qa user"
