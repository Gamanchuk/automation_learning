@pepBoys

Feature: Some feature

  Background:
    Given user makes appoint with code "94105"
    And user add to cart product with id "8536851" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("16248")
  Scenario: Place Order as a "Guest" with Credit Card
    Given user makes authorisation for "qa user"
    And applies billing info for address "201 SPEAR ST"
    And chooses "Ground" shipping method
    And uses "visa" card for payment
    Then user should be on thank you page

