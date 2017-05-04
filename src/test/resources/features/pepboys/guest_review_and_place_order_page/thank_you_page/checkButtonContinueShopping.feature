@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15421")
  Scenario: Check button Continue Shopping
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment
    And presses the "Place Order" button
    And user should be on thank you page
    Then presses the "Continue Shopping" button
    And user should be on main page

    # Need to change attribute at line 7 from "ship to home" to "Pick up in store"
    # And remove lines: 15, 16