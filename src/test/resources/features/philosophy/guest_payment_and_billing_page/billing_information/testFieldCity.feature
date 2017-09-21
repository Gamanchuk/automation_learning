@philosophy

Feature: GUEST - PAYMENT & BILLING ADDRESS PAGE - BILLING ADDRESS

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

  @TestCaseId("17121")
  Scenario: Test field 'City'
    Given uses "mastercard" card for payment
    And user fills email field with "qa@moovweb.com"
    And unset checkbox "Please send me philosophy emails for inspiration, exclusive offers and product information."
    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user" without email

    And user types "" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "SanFrancisco" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Review" tab

    And user navigates to "Payment" breadcrumb
    And user types "123456" into the "City" field of "Billing Address" address form
    And uses "mastercard" card for payment
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Review" tab

    And user navigates to "Payment" breadcrumb
    And user types "!@$%^&*():_+" into the "City" field of "Billing Address" address form
    And uses "mastercard" card for payment
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Review" tab

