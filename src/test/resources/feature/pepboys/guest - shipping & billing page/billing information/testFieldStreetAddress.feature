@pepBoys


Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15498")
  Scenario: Test field 'Address Street'
    Given user types billing info for "qa user"
    And user types " " in "street address" on billing info tab
    And presses the "Continue" button
    Then user stay at billing tab with error message

    And user types "Mission Street" in "street address" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user check "street address" with value "Mission Street"
    And user navigate back on "Billing & Shipping"

    And user types "123456" in "street address" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user check "street address" with value "123456"
    And user navigate back on "Billing & Shipping"

    And user types "!@$%^&*():_+" in "street address" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user check "street address" with value "!@$%^&*():_+"
