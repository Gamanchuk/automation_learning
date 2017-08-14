@shoe

Feature: EXISTING ACCOUNT - SHIPPING PAGE - PICK UP IN STORE

  Background: Add product to card and process to checkout
    Given user adds product to cart with Pick up in store from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And user navigates to "Pick up in Store" tab
    And user fills find store field with "10020"
    And presses the "Search" button
    Then user should be see Store results
    And user selects random store

  @TestCaseId("16774")
  Scenario: Test field 'Last name'

    Given user types "Moovweb" into the "Full Name" field of "Contact Details" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Moovweb !@#&::!@#()" into the "Full Name" field of "Contact Details" address form
    And presses the "Continue" button
    Then user should be on "Payment" tab



