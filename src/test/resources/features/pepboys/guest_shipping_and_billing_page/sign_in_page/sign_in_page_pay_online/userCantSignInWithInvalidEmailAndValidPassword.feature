@pepBoys @debug

Feature: Sign In page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15531")
  Scenario: User can't sign in with invalid "email address" and valid "password"
    Given user email "notqa@moovweb.com" password "Spear201!" makes authorisation
    Then sees "FORM ERRORS" error message with text "Your login attempt was not successful, try again."
    