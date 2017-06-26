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

  @TestCaseId("102277")
  Scenario: Test field "Expiration"
    Given user should be on "Payment" tab
    And selects "Enter a New Card"
    And uses "visa" card for payment

    And user types "01" into "Expiration" field of Card Form
    And sees error tooltip with text "Expiration date must be in the format MM/YY"
    And presses the "Place Order" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "01255" into "Expiration" field of Card Form
    And sees error tooltip with text "Expiration date must be in the format MM/YY"
    And presses the "Place Order" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "" into "Expiration" field of Card Form
    And sees error tooltip with text "Expiration date can't be blank"
    And presses the "Place Order" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."
