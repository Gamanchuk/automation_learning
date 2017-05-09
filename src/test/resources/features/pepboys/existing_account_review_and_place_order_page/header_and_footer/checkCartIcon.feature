@pepBoys

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15451")
  Scenario: Check Shopping cart icon redirection
    Given user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And user presses the Shopping Cart icon
    Then user should be on cart page
