@qvc

Feature: GUEST - PAYMENT PAGE - QCARD

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types manually billing info for "qa user" without email
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

    And uses "qcard2" card for payment
    And presses the "Continue" button

    And user should be on "Review" tab


