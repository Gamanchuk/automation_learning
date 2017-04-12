@pepBoys

Feature: Guest - Thank You Page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16662")
  @TestCaseId("16661")
  Scenario: Check button Continue Shopping (Existing User, Pay in Store)
    Given user types billing info for "qa user"
    And presses the "Place Order" button
    And user should be on thank you page
    Then presses the "Continue Shopping" button
    And user should be on main page
