@pepBoys

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5848")
  @TestCaseId("15516")
  Scenario: Test field 'Street Address'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"
    And user types billing info for "qa user" and checks email

    And user types "" into the "Street Address" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mission Street" into the "Street Address" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks "Street Address" with value "Mission Street" on "Delivery Method" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "123456" into the "Street Address" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks "Street Address" with value "123456" on "Delivery Method" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "!@$%^&*():_+" into the "Street Address" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks "Street Address" with value "!@$%^&*():_+" on "Delivery Method" tab
