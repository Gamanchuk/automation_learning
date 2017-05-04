@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15422")
  Scenario: Links at Thank you page
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment
    And presses the "Place Order" button
    And user should be on thank you page
    Then user presses the Find out more link
    And user should be on rewards page

    # Need to change attribute at line 7 from "ship to home" to "Pick up in store"
    # And remove lines: 16, 17

