@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102326")
  Scenario: Test field 'Street Address'
    Given user types manually billing info for "qa user" without email
    And user types manually shipping info for "qa user" without email, phone

    And user types "" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mission Street" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab

    And user navigates to "Address" breadcrumb
    And user types "123456" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab

    And user navigates to "Address" breadcrumb
    And user types "!@$%^&*():_+" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab
