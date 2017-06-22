@qvc


Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102415")
  Scenario: Test field 'Address Street'
    Given selects "Enter a New Address" for shipping address
    And user types shipping address for "qa user"
    And unset checkbox "Save this address to my address book"

    And user types "" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mission Street" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "123456" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    And user types "!@$%^&*():_+" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab
