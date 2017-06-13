@qvc 

Feature: GUEST - SHIPPING & BILLING ADDRESS PAGE

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102326")
  Scenario: Test field 'Address Street'
    Given user types manually billing info for "qa user" without email
    And user types shipping info for "qa user"

    And user types "" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mission Street" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Delivery" tab
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "discover" card for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "Street Address" with value "Mission Street" on "Review" tab

    And user navigates to "Address" breadcrumb
    And user types "123456" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Delivery" tab
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "discover" card for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "Street Address" with value "123456" on "Review" tab

    And user navigates to "Address" breadcrumb
    And user types "!@$%^&*():_+" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Delivery" tab
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "discover" card for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user checks "Street Address" with value "!@$%^&*():_+" on "Review" tab
