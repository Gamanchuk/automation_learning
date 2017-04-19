@pepBoys

Feature: EXISTING ACCOUNT - THANK YOU PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "9046557" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15473")
  @TestCaseId("15471")
  Scenario: Check button Continue Shopping (Existing User, Pay Online)
    Given user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button
    And uses "visa" card for payment
    And presses the "Place Order" button
    And user should be on thank you page
    Then presses the "Continue Shopping" button
    And user should be on main page