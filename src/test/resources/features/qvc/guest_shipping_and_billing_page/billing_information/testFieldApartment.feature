@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO - DOMESTIC

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    Then user types billing info for "qa user" without email

  @TestCaseId("102397")
  Scenario: Test field 'Apartment'

    When user types "" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    When user types "12345" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    When user types "Some Apartment" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    When user types "!#&@()" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab



