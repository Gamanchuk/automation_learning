@qvc @debug1

Feature: GUEST - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102394")
  Scenario: Test field 'Name'
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email

    And user types "" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#&( !@#()" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mr Donal Trump III" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab