@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @Issue("MCCAT-5562")
  @TestCaseId("15416")
  Scenario: Change Store
    Given user types customer info for "qa user"
    And user clicks arrow for "Pick Up in Store"
    And user should be on cart page
    And user changes store
    And chooses "Pay in Store" method
    And checks Pick Up in Store info




