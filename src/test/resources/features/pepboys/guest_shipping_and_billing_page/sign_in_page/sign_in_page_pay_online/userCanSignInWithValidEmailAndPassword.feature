@pepBoys @debug

Feature: Sign In page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15529")
  Scenario: User can sign in with valid "email address" and valid "password"
    Given user makes authorisation for "qa user"
    Then user should be on "Billing & Shipping" tab
    