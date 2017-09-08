@philosophy

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds products to cart "4" from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest

  @TestCaseId("17097")
  Scenario: Place multiple order as guest with Credit Card

    Given user types shipping info for "qa user" without email
    And presses the "Continue" button

    Then user should be on "Delivery" tab
    And presses the "Continue" button

    Then user should be on "Payment" tab
    And uses "mastercard" card for payment
    And user fills email field with "qamoovwem@automation.com"
    And unset checkbox "Please send me philosophy emails for inspiration, exclusive offers and product information."
    And presses the "Continue" button

    Then user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page
