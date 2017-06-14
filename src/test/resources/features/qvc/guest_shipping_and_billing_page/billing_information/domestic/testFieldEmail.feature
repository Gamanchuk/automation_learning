@qvc @debug1

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102403")
  Scenario: Test field 'Email'
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email

    And user types "" into the email field
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "#######@moovweb.com" into the email field
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Email Address is invalid"

    And user types "qamoovweb.com" into the email field
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "123456@moovweb.com" into the email field
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "qa@moovweb" into the email field
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "qa@moovweb.com" into the email field
    And presses the "Continue" button
    Then user should be on "Delivery" tab







