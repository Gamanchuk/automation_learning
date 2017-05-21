@pepBoys

Feature: PAY IN STORE - GUEST - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16662")
  @TestCaseId("16661")
  Scenario: Check button Continue Shopping
    Given user types customer info for "qa user"
    And presses the "Place Order" button
    And user should be on thank you page
    Then presses the "Continue Shopping" button
    And user should be on main page
