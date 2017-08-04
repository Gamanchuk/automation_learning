@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And selects "Enter a New Card"

  @TestCaseId("16801")
  @TestCaseId("16798")
  Scenario: Test field "CVV"

    Given uses "visa" card for payment

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
