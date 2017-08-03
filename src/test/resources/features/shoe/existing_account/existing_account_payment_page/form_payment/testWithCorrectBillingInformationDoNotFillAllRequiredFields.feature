@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And user types shipping info for "qa user" without email
    And unset checkbox "Save this address to my address book"
    And presses the "Continue" button
    Then user should be on "Payment" tab

  @TestCaseId("16797")
  Scenario: Test with correct billing information and do not fill in all required fields

    Given presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

