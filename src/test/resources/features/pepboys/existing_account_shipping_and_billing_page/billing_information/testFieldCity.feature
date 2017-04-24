@pepBoys

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15518")
  Scenario: Test field 'City'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"
    And user types shipping info for "qa user"

    And user types "" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "SanFrancisco" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks city info with value "SanFrancisco" on "Payment & Review" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "123456" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks city info with value "123456" on "Payment & Review" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "!@$%^&*():_+" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks city info with value "!@$%^&*():_+" on "Payment & Review" tab


