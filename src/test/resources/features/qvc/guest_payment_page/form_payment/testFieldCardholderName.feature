@qvc

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("")
  Scenario: Test field "Cardholder Name"
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types billing info for "qa user" without email
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And presses the "Continue" button
    And uses "amex" card for payment

    And user types "" into "Cardholder Name" field of Card Form
    And presses the "Place Order" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#$%^&*())(*&^%$#@! !@#$%^&*())(*&^%$#@!" into "Cardholder Name" field of Card Form
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."
