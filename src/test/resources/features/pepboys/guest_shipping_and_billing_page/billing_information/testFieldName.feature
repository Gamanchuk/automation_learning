@pepBoys


Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15496")
  Scenario: Test field 'Name'
#    Given user types billing info for "qa user"
#    And user types " " into the "Full Name" field
#    And presses the "Continue" button
#    Then user stays at billing tab with error message
#
#    And user types "!@#&( !@#()" into the "Full Name" field
#    And presses the "Continue" button
#    Then user stays at billing tab with error message
#
#    And user types "Mr Donal Trump III" into the "Full Name" field
#    And presses the "Continue" button
#    And chooses "Use Entered Address"
#    Then user checks "Full Name" with value "Mr Donal Trump III"


