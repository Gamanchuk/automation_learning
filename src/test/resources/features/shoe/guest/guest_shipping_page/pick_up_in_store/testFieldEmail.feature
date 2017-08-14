@shoe

Feature: GUEST - SHIPPING PAGE - PICK UP IN STORE

  Background: Add product to card and process to checkout
    Given user adds product to cart with Pick up in store from Shoe
    And user navigates to "Pick up in Store" tab
    And user fills find store field with "10020"
    And presses the "Search" button
    Then user should be see Store results
    And user selects random store

  @TestCaseId("16284")
  Scenario: Test field 'Email'

    Given user types "qa@moovweb.com" into the "Email" field of "Contact Details" address form

    And user types "" into the "Full Name" field of "Contact Details" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#&( !@#()" into the "Full Name" field of "Contact Details" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mr Donal Trump III" into the "Full Name" field of "Contact Details" address form
    And presses the "Continue" button
    Then user should be on "Payment" tab
