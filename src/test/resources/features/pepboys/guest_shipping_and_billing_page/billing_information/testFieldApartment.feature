@pepBoys, @debug

Feature: Guest - Shipping & Billing page

  Background: Set Up preconditions for testing billing page
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15499")
  Scenario: Test field 'Apartment'
    Given user types billing info for "qa user"
    And user types " " into the "Apt, Bldg." field
    And presses the "Continue" button
    Then user checks billing info for "qa user"
#    And user navigates back on "Billing & Shipping"
#
#    And user types "12345" into the "Apt, Bldg." field
#    And presses the "Continue" button
#    Then user checks "Apt, Bldg." with value "12345"
#    And user navigates back on "Billing & Shipping"
#
#    And user types "Some Apartment" into the "Apt, Bldg." field
#    And presses the "Continue" button
#    Then user checks "apt" with value "Some Apartment"
#    And user navigates back on "Billing & Shipping"
#
#    And user types "!#&@()" into the "Apt, Bldg." field
#    And presses the "Continue" button
#    Then user checks "Apt, Bldg." with value "!#&@()"




