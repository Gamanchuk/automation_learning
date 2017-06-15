@qvc

Feature: GUEST - SHIPPING & BILLING ADDRESS PAGE

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102327")
  Scenario: Test field 'Apartment'
    Given user types manually billing info for "qa user" without email
    And user types shipping info for "qa user"

    And user types "" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "discover" card for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "Apt, Bldg." with value "" on "Review" tab


    And user navigates to "Address" breadcrumb
    And user types "12345" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "discover" card for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "Apt, Bldg." with value "12345" on "Review" tab


    And user navigates to "Address" breadcrumb
    And user types "Some Apartment" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "discover" card for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "Apt, Bldg." with value "Some Apartment" on "Review" tab


    And user navigates to "Address" breadcrumb
    And user types "!#&@()" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "discover" card for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "Apt, Bldg." with value "!#&@()" on "Review" tab




