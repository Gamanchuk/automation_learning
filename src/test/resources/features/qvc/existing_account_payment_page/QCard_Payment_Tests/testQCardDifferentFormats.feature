@qvc

Feature: EXISTING ACCOUNT - PAYMENT PAGE - QCARD

  Background:
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And presses the "Continue" button

  @TestCaseId("101823")
  @TestCaseId("101824")
  @TestCaseId("101829")
  @TestCaseId("101830")
  Scenario: Test QCard fields and format
    Given user should be on "Payment" tab
    And user selects "1 payment" Payment Option
    And selects "Enter a New Card"
    And uses "partial-qcard" card for payment
    And presses the "Continue" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And uses saved "qcard" card for payment
    And presses the "Continue" button

    And sees "FORM ERRORS" error message with text "Please review all inputs."



