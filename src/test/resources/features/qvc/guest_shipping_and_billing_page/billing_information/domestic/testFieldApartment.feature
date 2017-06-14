@qvc @debug1

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102397")
  Scenario: Test field 'Apartment'
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email

    And user types "" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "12345" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "Some Apartment" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "!#&@()" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb


