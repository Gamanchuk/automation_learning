@pepBoys

Feature: Some feature

  Background:
    Given user makes appoint with code "94105"
    And user add to cart product with id "8536851" with "Ship to Home" delivery option
    And user views cart
    And chooses "PayPal" method
    And user confirms purchase as "qa user" with PayPal


  @TestCaseId("16249")
  Scenario: Place Order with Paypal from Shopping cart page
    And chooses "Ground" shipping method
    And user confirms purchase
    Then user should be on thank you page

