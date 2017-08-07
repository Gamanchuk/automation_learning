@shoe

Feature: EXISTING ACCOUNT - SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And selects "Enter a New Address" for shipping address
    And user types shipping info for "qa user" without email
    Then unset checkbox "Save this address to my address book"

  @TestCaseId("16749")
  Scenario: Test field 'Name'

    Given user types "" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#&( !@#()" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mr Donal Trump III" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Payment" tab
