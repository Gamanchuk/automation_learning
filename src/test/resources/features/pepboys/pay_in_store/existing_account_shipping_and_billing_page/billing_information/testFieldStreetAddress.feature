@pepBoys @debug

Feature: PAY IN STORE - EXISTING ACCOUNT - SHIPPING & BILLING PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16632")
  Scenario: Test field 'Address Street'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"
    And user types shipping info for "qa user"

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
