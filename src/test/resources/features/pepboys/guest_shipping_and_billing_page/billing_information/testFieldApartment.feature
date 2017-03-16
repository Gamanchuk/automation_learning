@pepBoys

Feature: Guest - Shipping & Billing page

  Background: Set Up preconditions for testing billing page
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15499")
  Scenario: Test field 'Apartment'
    Given user types billing info for "qa user"
    And user types " " in "apt" on billing info tab
    And presses the "Continue" button
    Then user checks billing info for "qa user"
    And user navigate back on "Billing & Shipping"

    And user types "12345" in "apt" on billing info tab
    And presses the "Continue" button
    Then user check "apt" with value "12345"
    And user navigate back on "Billing & Shipping"

    And user types "Some Apartment" in "apt" on billing info tab
    And presses the "Continue" button
    Then user check "apt" with value "Some Apartment"
    And user navigate back on "Billing & Shipping"

    And user types "!#&@()" in "apt" on billing info tab
    And presses the "Continue" button
    Then user check "apt" with value "!#&@()"




