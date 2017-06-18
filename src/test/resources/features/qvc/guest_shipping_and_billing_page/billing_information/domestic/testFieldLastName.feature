@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO - DOMESTIC

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    Then user types billing info for "qa user" without email

  @TestCaseId("102395")
  Scenario: Test field 'Last name'

    When user types "Moovweb" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should be on "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    When user types "Moovweb !@#&::!@#()" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab



