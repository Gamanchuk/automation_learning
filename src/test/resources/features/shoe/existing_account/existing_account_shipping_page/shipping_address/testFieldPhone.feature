@shoe

Feature: EXISTING ACCOUNT - SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And user types shipping info for "qa user" without email
    Then unset checkbox "Save this address to my address book"

  @TestCaseId("16756")
  Scenario: Test field 'Phone'

    Given user types "" into the "Phone Number" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "4152011234" into the "Phone Number" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Payment" tab
