@pepBoys, @debug


Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15497")
  Scenario: Test field 'Last name'
    Given user types billing info for "qa user"
    And user types "Moovweb" in "name" on billing info tab
    And presses the "Continue" button
    Then user stay at billing tab with error message

    And user types "Moovweb !@#&::!@#()" in "name" on billing info tab
    And presses the "Continue" button
    Then user stay at billing tab with error message

