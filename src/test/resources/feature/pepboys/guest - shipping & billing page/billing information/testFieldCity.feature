@pepBoys

Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15500")
  Scenario: Test field 'City'
    Given user types billing info for "qa user"
    And user types " " in "city" on billing info tab
    And presses the "Continue" button
    Then user stay at billing tab with error message

    And user types "SanFrancisco" in "city" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user check "city" with value "SanFrancisco"
    And user navigate back on "Billing & Shipping"

    And user types "123456" in "city" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user check "city" with value "123456"
    And user navigate back on "Billing & Shipping"

    And user types "!@$%^&*():_+" in "city" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user check "city" with value "!@$%^&*():_+"


