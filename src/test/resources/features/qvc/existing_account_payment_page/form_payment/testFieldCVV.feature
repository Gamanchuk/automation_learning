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

  @TestCaseId("102276")
  Scenario: Test field "CVV"
    Given user should be on "Payment" tab
    And user selects "1 payment" Payment Option
    And selects "Enter a New Card"
    And uses "visa2" card for payment

    And user types "01" into "CVV" field of Card Form
    And sees error tooltip with text "Cvv is the wrong length (should be 3 characters)"
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "0111" into "CVV" field of Card Form
    And sees error tooltip with text "Cvv is the wrong length (should be 3 characters)"
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "" into "CVV" field of Card Form
    And sees error tooltip with text "Cvv can't be blank"
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."
