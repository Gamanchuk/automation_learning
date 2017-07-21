@saatva

Feature: PAYMENT & REVIEW - PAYMENT INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

  @TestCaseId("100996")
  Scenario: Test field "Card Number"
    Given user types shipping address for "qa user" with phone number
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab

    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

