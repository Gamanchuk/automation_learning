@pepBoys

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5505")
  @TestCaseId("15473")
  Scenario: Check button Continue Shopping
    Given user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button

    And user should be on "Payment & Review" tab
    And uses "visa" card for payment
    And presses the "Place Order" button
    And user should be on thank you page
    Then presses the "Continue Shopping" button
    And user should be on main page
