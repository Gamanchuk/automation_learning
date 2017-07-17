@qvc

Feature: GUEST - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102337")
  Scenario: Test field "CVV"
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types billing info for "qa user" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"

    And user should be on "Delivery" tab
    And presses the "Continue" button
    And uses "amex" card for payment

    And user types "01" into "CVV" field of Card Form
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "0111" into "CVV" field of Card Form
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "" into "CVV" field of Card Form
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."
