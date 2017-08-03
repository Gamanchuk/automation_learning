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

  @TestCaseId("16800")
  @TestCaseId("16798")
  Scenario: Test field "Expiration"

    Given uses "visa" card for payment

    And user types "01" into "Expiration" field of Card Form
    And sees error tooltip with text "Expiration date must be in the format MM/YY"
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "01255" into "Expiration" field of Card Form
    And sees error tooltip with text "Expiration date must be in the format MM/YY"
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "" into "Expiration" field of Card Form
    And sees error tooltip with text "Expiration date can't be blank"
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."
