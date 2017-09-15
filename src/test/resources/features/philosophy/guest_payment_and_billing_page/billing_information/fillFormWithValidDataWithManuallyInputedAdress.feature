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

  @TestCaseId("17113")
  Scenario: Test with correct billing information and fill in all required fields (Address input manually)

    Given uses "mastercard" card for payment
    And user fills email field with "qa@moovweb.com"
    And unset checkbox "Please send me philosophy emails for inspiration, exclusive offers and product information."
    
    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types manually billing info for "qa user" without email
    And presses the "Continue" button

    Then user should be on "Review" tab



