@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15398")
  Scenario: Check Cart icon
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment
    And user presses the Shopping Cart icon
    Then user should be on cart page

    # Need to change attribute at line 7 from "ship to home" to "Pick up in store"
    # And remove lines: 17,18
    # Also we don't need to input information about CC => can remove line 19