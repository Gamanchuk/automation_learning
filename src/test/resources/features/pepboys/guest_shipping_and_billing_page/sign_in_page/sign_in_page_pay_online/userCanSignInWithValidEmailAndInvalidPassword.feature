@pepBoys

Feature: Sign In page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15530")
  Scenario: Verify if user can sign in with valid "email address" and invalid "password"
    Given user makes authorisation for "qa user"
    Then user should stay at "Billing & Shipping" tab
    