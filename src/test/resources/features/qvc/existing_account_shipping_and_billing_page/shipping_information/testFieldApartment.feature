@qvc

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102416")
  Scenario: Test field 'Apartment'

    Given selects "Enter a New Address" for shipping address
    And user types shipping info for "qa user" without email, phone
    And unset checkbox "Save this address to my address book"

    And user types "" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "12345" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "Some Apartment" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "!#&@()" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab




