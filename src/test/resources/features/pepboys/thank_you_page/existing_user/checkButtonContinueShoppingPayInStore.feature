@pepBoys @debug

Feature: Existing User - Thank You Page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16675")
  Scenario: Check button Continue Shopping (Existing User, Pay in Store)
    Given user presses the signIn button
    And user makes authorisation for "qa user"
    And applies billing info for address "201 SPEAR ST"
    And presses the "Place Order" button
    And user should be on thank you page
    And presses the "Continue" button
    And user should be on cart page

