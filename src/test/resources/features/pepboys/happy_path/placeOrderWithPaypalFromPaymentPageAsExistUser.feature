@pepBoys 

Feature: HAPPY PATH

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("16251")
  Scenario: Place Order with Paypal from Payment page as Exist use
    Given user makes authorisation for "qa user"
    And applies billing info for address "201 SPEAR ST"
    And presses the "Continue" button
#    And chooses "Ground: 5-7 Days" shipping method
#    And presses the "Continue" button
    And uses PayPal for payment
    And user confirms purchase as "qa user" with PayPal
    Then user should be on thank you page

  