@pepBoys


Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15503")
  Scenario: Test field 'Phone'
    Given user types billing info for "qa user"
    And user types " " in "phone" on billing info tab
    And presses the "Continue" button
    Then user stay at billing tab with error message

    And user types "phoneNumber" in "phone" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user stay at billing tab with error message

    And user types "!@$%^&*():_" in "phone" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user stay at billing tab with error message

    And user types "4152011234" in "phone" on billing info tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user check "phone" with value "4152011234"

