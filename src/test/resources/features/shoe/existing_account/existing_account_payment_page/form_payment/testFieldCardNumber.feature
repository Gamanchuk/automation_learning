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

  @TestCaseId("16799")
  @TestCaseId("16798")
  Scenario: Test field "Card Number"

    Given uses "visa" card for payment

    And user types "1" into "Card Number" field of Card Form
    And sees error tooltip with text "Card number is invalid - please double-check the card number."
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "11111111111111111" into "Card Number" field of Card Form
    And sees error tooltip with text "Card number is invalid - please double-check the card number."
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "" into "Card Number" field of Card Form
    And sees error tooltip with text "Card number can't be blank"
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."
