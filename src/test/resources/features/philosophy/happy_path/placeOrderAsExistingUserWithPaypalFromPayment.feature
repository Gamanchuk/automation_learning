@philosophy

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user makes authorisation for "qa user"


  @TestCaseId("17096")
  Scenario: Place order with Paypal from payment as Existing User

    Given user should be on "Shipping" tab
    And presses the "Continue" button

    Then user should be on "Delivery" tab
    And presses the "Continue" button

    Then user should be on "Payment" tab
    And user chooses "PayPal" for payment
    And unset checkbox "Please send me philosophy emails for inspiration, exclusive offers and product information."
    And  presses the "Continue with PayPal" button

    Then user should be on "Review" tab
    And presses the "Place Order" button
    And user confirms purchase as "qa user" with PayPal
    Then user should be on thank you page
