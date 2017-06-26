@qvc

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102407")
  Scenario: Test with correct shipping information and do not fill in all required fields

    Given selects "Enter a New Address" for shipping address
    And unset checkbox "Save this address to my address book"
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

