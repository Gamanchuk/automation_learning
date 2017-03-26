@pepBoys @refactoring @ignore


Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15502")
  Scenario: Test field 'Zip Code'
    Given user types billing info for "qa user"
    And user types "" into the "Zip Code" field
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "ZIP Code is required"

    And user types "zipCode" into the "Zip Code" field
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "ZIP Code is invalid (xxxxx or xxxxx-xxxx)"

    And user types "!@$%^&*():_+" into the "Zip Code" field
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "ZIP Code is invalid (xxxxx or xxxxx-xxxx)"

    And user types "94105" into the "Zip Code" field
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks zip code with value "94105" on "Delivery Method" tab
