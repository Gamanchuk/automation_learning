@qvc

Feature: GUEST - PAYMENT PAGE - QCARD

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And presses the "Continue" button

  @TestCaseId("101823")
  @TestCaseId("101824")
  @TestCaseId("101829")
  @TestCaseId("101830")
  Scenario: Test QCard fields and format
    Given user should be on "Payment" tab
    And uses "partial-qcard" card for payment
    And presses the "Continue" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And uses "qcardNEW" card for payment
    And presses the "Continue" button

    And sees "FORM ERRORS" error message with text "We are sorry. The system encountered an error processing this request. You may have entered an invalid credit card number. Please review your entry to ensure all fields are numeric. Letters and dashes cannot be accepted. If you are sure you entered the number correctly, the credit card may already be on file on another account. For assistance, please contact Customer Service at 1-888-345-5788"



