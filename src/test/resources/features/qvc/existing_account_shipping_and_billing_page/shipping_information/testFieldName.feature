@qvc


Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102413")
  Scenario: Test field 'Name'
    Given selects "Enter a New Address" for shipping address
    And user types shipping address for "qa user"
    And unset checkbox "Save this address to my address book"

    And user types "" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#&( !@#()" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mr Donal Trump III" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab

