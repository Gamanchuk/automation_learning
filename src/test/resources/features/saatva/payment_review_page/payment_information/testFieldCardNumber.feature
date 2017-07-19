@saatva

Feature: PAYMENT & REVIEW - PAYMENT INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

  @TestCaseId("100998")
  @TestCaseId("100997")
  Scenario: Test field "Card Number"
    Given user types shipping address for "qa user" with phone number
    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab
    And uses "mastercard" card for payment

    And user types "1" into "Card Number" field of Card Form
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "11111111111111111" into "Card Number" field of Card Form
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "" into "Card Number" field of Card Form
    And presses the "Place Order" button
    Then user should stay at "Payment & Review" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."
