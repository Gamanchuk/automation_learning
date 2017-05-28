@pepBoys

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5848")
  @TestCaseId("15500")
  Scenario: Test field 'City'
    Given user types billing info for "qa user"
    And user types "" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "SanFrancisco" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks city info with value "SanFrancisco" on "Delivery Method" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "123456" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks city info with value "123456" on "Delivery Method" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "!@$%^&*():_+" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks city info with value "!@$%^&*():_+" on "Delivery Method" tab
