@pepBoys

Feature: Sign In page (Pay in Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16680")
  Scenario: User can't sign in with invalid "email address" and valid "password" (Pay in Store)
    Given user makes authorisation with "notqa@moovweb.com" email and "Spear201!" password
    Then sees "FORM ERRORS" error message with text "Your login attempt was not successful, try again."
    