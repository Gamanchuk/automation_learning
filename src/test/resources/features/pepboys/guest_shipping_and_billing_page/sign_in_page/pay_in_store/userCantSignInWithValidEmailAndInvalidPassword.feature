@pepBoys @debug

Feature: Sign In page (Pay in Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16679")
  Scenario: User can't sign in with valid "email address" and invalid "password" (Pay in Store)
    Given user email "qa@moovweb.com" password "invalid" makes authorisation
    Then sees "FORM ERRORS" error message with text "Your login attempt was not successful, try again."
    