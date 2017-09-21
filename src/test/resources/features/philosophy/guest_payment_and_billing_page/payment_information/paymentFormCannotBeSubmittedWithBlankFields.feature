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

  @TestCaseId("17139")
  @TestCaseId("17140")
  Scenario: Test blank payment form error validation and valid info
    Given presses the "Continue" button
    And user should be on "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And uses "mastercard" card for payment
    And user fills email field with "qamoovweb@automation.com"

    And presses the "Continue" button
    Then user should be on "Review" tab


