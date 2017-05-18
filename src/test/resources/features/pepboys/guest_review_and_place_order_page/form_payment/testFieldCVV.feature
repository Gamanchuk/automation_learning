@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15405")
  Scenario: Test field "CVV"
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And uses "visa" card for payment

    And user types "01" into "CVV" field of Card Form
    And sees error tooltip with text "Cvv is the wrong length (should be 3 characters)"
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "0111" into "CVV" field of Card Form
    And sees error tooltip with text "Cvv is the wrong length (should be 3 characters)"
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "" into "CVV" field of Card Form
    And sees error tooltip with text "Cvv can't be blank"
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."
