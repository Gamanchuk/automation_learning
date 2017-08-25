@qvc

Feature: EXISTING ACCOUNT - PAYMENT PAGE

  Background:
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And presses the "Continue" button

  @TestCaseId("102272")
  @TestCaseId("102275")
  Scenario: Test field "Card Number"
    Given user should be on "Payment" tab
    And user selects "1 payment" Payment Option
    And selects "Enter a New Card"
    And uses "visa2" card for payment

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
