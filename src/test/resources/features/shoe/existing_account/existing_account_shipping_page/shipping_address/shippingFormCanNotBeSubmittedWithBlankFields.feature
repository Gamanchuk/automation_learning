@shoe

Feature: EXISTING ACCOUNT - SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And selects "Enter a New Address" for shipping address

  @TestCaseId("16748")
  Scenario: Test with correct shipping information and do not fill in all required fields

    Given unset checkbox "Save this address to my address book"
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

