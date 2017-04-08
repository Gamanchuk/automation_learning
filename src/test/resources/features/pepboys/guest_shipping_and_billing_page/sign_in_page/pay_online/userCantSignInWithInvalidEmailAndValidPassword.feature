@pepBoys

Feature: Sign In page (Pay Online)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15531")
  Scenario: User can't sign in with invalid "email address" and valid "password" (Pay Online)
    Given user makes authorisation with "notqa@moovweb.com" email and "Spear201!" password
    Then sees "FORM ERRORS" error message with text "Your login attempt was not successful, try again."
    