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
    And user presses the Shopping Cart icon
    Then user should be on cart page
