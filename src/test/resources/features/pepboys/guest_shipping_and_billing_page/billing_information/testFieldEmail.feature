@pepBoys

Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15504")
  Scenario: Test field 'Email'
    Given user types billing info for "qa user"

#    And user types " " into the "email" field
#    And presses the "Continue" button
#    Then user stays at billing tab with error message
#
#    And user types "#######@moovweb.com" into the "email" field
#    And presses the "Continue" button
#    And chooses "Use Entered Address"
#    Then user stays at billing tab with error message
#
#    And user types "qa@moovweb" into the "email" field
#    And presses the "Continue" button
#    Then user stays at billing tab with error message
#
#    And user types "qamoovweb.com" into the "email" field
#    And presses the "Continue" button
#    Then user stays at billing tab with error message
#
#    And user types "123456@moovweb.com" into the "email" field
#    And presses the "Continue" button
#    And chooses "Use Entered Address"
#    Then user checks "email" with value "123456@moovweb.com"
#    And user navigates back on "Billing & Shipping"
#
#    And user types "qa@moovweb.com" into the "email" field
#    And presses the "Continue" button
#    And chooses "Use Entered Address"
#    Then user checks "email" with value "qa@moovweb.com"





