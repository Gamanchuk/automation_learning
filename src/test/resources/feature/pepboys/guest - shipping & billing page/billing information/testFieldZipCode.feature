@pepBoys, @debug


Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15502")
  Scenario: Test field 'Zip Code'
    Given user types billing info for "qa user"
    And user types " " in "zip" on billing info tab
    And presses the "Continue" button
    Then user stay at billing tab with error message

    And user types "zipCode" in "zip" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user stay at billing tab with error message

    And user types "!@$%^&*():_+" in "zip" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user stay at billing tab with error message

    And user types "94105" in "zip" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user check "zip" with value "94105"

