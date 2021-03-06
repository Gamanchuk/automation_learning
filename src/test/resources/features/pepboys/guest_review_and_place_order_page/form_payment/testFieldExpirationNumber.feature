@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15404")
  Scenario: Test field "Expiration"
    Given user types billing info for "qa user"
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment

    And user types "01" into "Expiration" field of Card Form
    And sees error tooltip with text "Expiration date must be in the format MM/YY"
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "01255" into "Expiration" field of Card Form
    And sees error tooltip with text "Expiration date must be in the format MM/YY"
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "" into "Expiration" field of Card Form
    And sees error tooltip with text "Expiration date can't be blank"
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."
