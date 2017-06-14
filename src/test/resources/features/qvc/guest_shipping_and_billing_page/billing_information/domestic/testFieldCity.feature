@qvc @debug1

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102398")
  Scenario: Test field 'City'
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email

    And user types "" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "SanFrancisco" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "123456" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "!@$%^&*():_+" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb
