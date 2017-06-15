@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO - DOMESTIC

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102402")
  Scenario: Test field 'Phone'
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email

    And user types "" into the "Phone Number" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "4152011234" into the "Phone Number" field of "Billing Address" address form
    And presses the "Continue" button
    And user should be on "Delivery" tab
