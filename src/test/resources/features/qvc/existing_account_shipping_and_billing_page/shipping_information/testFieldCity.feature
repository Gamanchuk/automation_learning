@qvc


Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("")
  Scenario: Test field 'City'
    Given selects "Enter a New Address" for shipping address
    And user types manually shipping info for "qa user" without email, phone
    And unset checkbox "Save this address to my address book"

    And user types "" into the "City" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "SanFrancisco" into the "City" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "123456" into the "City" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "!@$%^&*():_+" into the "City" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab



