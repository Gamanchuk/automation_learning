@qvc @debug1

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @Issue("MCCAT-")
  @TestCaseId("102395")
  Scenario: Test field 'Last name'
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email

    And user types "Moovweb" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    And user should be on "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Moovweb !@#&::!@#()" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    And user should be on "Address" tab
    And sees "FORM ERRORS" error message with text "Last Name is invalid"



