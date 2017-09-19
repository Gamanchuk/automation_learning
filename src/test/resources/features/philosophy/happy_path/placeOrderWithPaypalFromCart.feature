@philosophy`

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "PayPal" method from Philosophy
    And user presses Log In PayPal button


  @TestCaseId("104633")
  Scenario: Place order with Paypal from cart as Guest

    Given user confirms purchase as "qa user" with PayPal
    Then user should be on "Delivery" tab

    And user types "4152011234" into the "Phone Number" field of "Contact Details" address form
    And unset checkbox "Sign up for emails and receive 15% off your first order"
    And presses the "Continue" button

    Then user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page
