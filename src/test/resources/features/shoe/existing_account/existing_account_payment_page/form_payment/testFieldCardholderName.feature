@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And selects "Enter a New Card"

  @TestCaseId("16803")
  @TestCaseId("16802")
  @TestCaseId("16798")
  Scenario: Test field "Cardholder Name"

    Given uses "visa" card for payment

    And user types "" into "Cardholder Name" field of Card Form
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#$%^&*())(*&^%$#@! !@#$%^&*())(*&^%$#@!" into "Cardholder Name" field of Card Form
    And presses the "Continue" button
    Then user should be on "Review" tab
