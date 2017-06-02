@pepBoys

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15457")
  Scenario: Test field "CVV"
    Given user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

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
