@saatva

Feature: PAYMENT & REVIEW - PAYMENT INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button


  @TestCaseId("100995")
  Scenario: Test with correct Mastercard billing information
    Given user types shipping address for "qa user" with phone number
    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"

    And user should be on "Payment & Review" tab

    And uses "mastercard" card for payment
    And presses the "Place Order" button