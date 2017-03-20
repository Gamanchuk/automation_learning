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
#    And user types " " into the "Street Address" field
#    And presses the "Continue" button
#    Then user stays at billing tab with error message
#
#    And user types "Mission Street" into the "Street Address" field
#    And presses the "Continue" button
#    And chooses "Use Entered Address"
#    Then user checks "Street Address" with value "Mission Street"
#    And user navigates back on "Billing & Shipping"
#
#    And user types "123456" into the "street address" field
#    And presses the "Continue" button
#    And chooses "Use Entered Address"
#    Then user checks "Street Address" with value "123456"
#    And user navigates back on "Billing & Shipping"
#
#    And user types "!@$%^&*():_+" into the "Street Address" field
#    And presses the "Continue" button
#    And chooses "Use Entered Address"
#    Then user checks "Street Address" with value "!@$%^&*():_+"
