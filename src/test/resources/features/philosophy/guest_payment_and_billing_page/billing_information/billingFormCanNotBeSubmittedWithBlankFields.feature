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

  @TestCaseId("17115")
  @TestCaseId("17116")
  Scenario: Test with correct shipping information and do not fill in all required fields (error message should be displayed)

    Given unset checkbox "Yes, billing address and shipping address are the same"
    And presses the "Continue" button
    And user should stay at "Payment" tab
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    And unset checkbox "Yes, billing address and shipping address are the same"
    And uses "mastercard" card for payment
    And user fills email field with "qa@moovweb.com"
    And unset checkbox "Please send me philosophy emails for inspiration, exclusive offers and product information."
    And user types manually billing info for "qa user" without email, phone

    And user types "" into the "Full Name" field of "Billing" address form
    And user types "" into the "City" field of "Billing" address form
    And selects "" state
    And user types "" into the "Zip Code" field of "Billing" address form
    And user types "" into the "Phone Number" field of "Billing" address form
    And user types "fl 10" into the "Apt, Bldg." field of "Billing" address form
    And presses the "Continue" button
    And user should stay at "Payment" tab
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "" into the "Street Address" field of "Billing" address form
    And user types "" into the "Apt, Bldg." field of "Billing" address form
    And presses the "Continue" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."


