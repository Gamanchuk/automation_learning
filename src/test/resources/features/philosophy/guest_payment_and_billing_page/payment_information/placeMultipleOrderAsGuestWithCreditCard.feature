@philosophy

Feature: GUEST - PAYMENT & BILLING ADDRESS PAGE - PAYMENT INFORMATION

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest
    Then user should be on "Shipping" tab
    And user types shipping info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab

  @TestCaseId("17145")
  @TestCaseId("17146")
  Scenario: Test fields 'Cardholder Name'

    Given uses "mastercard" card for payment
    And user fills email field with "qa@moovweb.com"

    And user types "" into "Cardholder Name" field of Card Form
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "qa" into "Cardholder Name" field of Card Form
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types " qa" into "Cardholder Name" field of Card Form
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "moovweb qa" into "Cardholder Name" field of Card Form
    And presses the "Continue" button
    Then user should be on "Review" tab
