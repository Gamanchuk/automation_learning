@pepBoys @debug

Feature: Happy Path

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15405")
  Scenario: Test field "Cardholder Name"
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground" shipping method
    And presses the "Continue" button

    And uses "visa" card for payment

    And user types "" into "Cardholder Name" field of Card Form
#    And sees error tooltip with text "Name can't be blank"
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#$%^&*())(*&^%$#@! !@#$%^&*())(*&^%$#@!" into "Cardholder Name" field of Card Form
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
#    And sees "FORM ERRORS" error message with text "Please review all inputs."

#    And user types "" into "Cardholder Name" field of Card Form
#    And sees error tooltip with text "Name can't be blank"
#    And presses the "Place Order" button
#    Then user should stay at "Payment & Review" tab
#    And sees "FORM ERRORS" error message with text "Please review all inputs."
