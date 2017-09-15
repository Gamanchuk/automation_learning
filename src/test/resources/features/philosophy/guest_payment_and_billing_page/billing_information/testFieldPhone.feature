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

  @Issues("MCCAT-6309")
  @TestCaseId("100989")
  @TestCaseId("101015")
  Scenario: Test field 'Phone'
    Given user types shipping address for "qa user" with phone number
    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user" without email

    When user types "" into the "Phone Number" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    When user types "4152011234" into the "Phone Number" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab
