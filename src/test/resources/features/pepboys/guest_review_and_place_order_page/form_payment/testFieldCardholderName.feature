@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15406")
  @TestCaseId("15407")
  Scenario: Test field "Cardholder Name"
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    And uses "visa" card for payment

    And user types "" into "Cardholder Name" field of Card Form
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#$%^&*())(*&^%$#@! !@#$%^&*())(*&^%$#@!" into "Cardholder Name" field of Card Form
    And presses the "Place Order" button
    Then sees modal error with text "Your order was declined"

    # We can make this test faster. Need to change attribute at line 7 from "Ship To Home" to "Pick Up In Store"
    # With this option we can remove lines: 18, 19
