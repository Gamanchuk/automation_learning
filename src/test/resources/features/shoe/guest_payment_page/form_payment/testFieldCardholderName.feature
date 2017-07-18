@shoe

Feature: GUEST - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    Then user should be on "Payment" tab

  @TestCaseId("16330")
  @TestCaseId("16331")
  Scenario: Test field "Cardholder Name"

    Given uses "visa" card for payment

    And user types "" into "Cardholder Name" field of Card Form
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#$%^&*())(*&^%$#@! !@#$%^&*())(*&^%$#@!" into "Cardholder Name" field of Card Form
    And presses the "Continue" button
    Then user should be on "Review" tab
