@pepBoys @debug

Feature: PAY IN STORE - EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16674")
  @TestCaseId("16673")
  Scenario: Check button Continue Shopping
    Given user makes authorisation for "qa user"
    And applies customer info for address "201 SPEAR ST"
    And presses the "Place Order" button
    And user should be on thank you page
    Then presses the "Continue Shopping" button
    And user should be on main page
