@pepBoys

Feature: GUEST - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5848")
  @TestCaseId("15380")
  Scenario: Test field 'Address Street'
    Given user types billing info for "qa user"
    And user types shipping info for "qa user" without email, phone
    And user types "" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mission Street" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks "Street Address" with value "Mission Street" on "Delivery Method" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "123456" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks "Street Address" with value "123456" on "Delivery Method" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "!@$%^&*():_+" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks "Street Address" with value "!@$%^&*():_+" on "Delivery Method" tab
