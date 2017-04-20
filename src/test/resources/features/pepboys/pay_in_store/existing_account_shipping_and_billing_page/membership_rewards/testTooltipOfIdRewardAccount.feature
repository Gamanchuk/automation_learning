@pepBoys

Feature: PAY IN STORE - EXISTING ACCOUNT - MEMBERSHIP REWARDS

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16624")
  Scenario: Tooltip of ID reward account must be present
    Given user makes authorisation for "qa user"
    And user should be on "Billing" page
    Then user checks rewards number for "qa user"
