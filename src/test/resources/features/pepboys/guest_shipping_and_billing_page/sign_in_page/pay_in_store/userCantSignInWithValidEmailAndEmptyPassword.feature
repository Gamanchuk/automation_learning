@pepBoys @debug

Feature: Sign In page (Pay in Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16683")
  Scenario: User can't sign in with valid "email address" and empty "password" (Pay in Store)
    Given user email "qa@moovweb.com" password "" makes authorisation
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
    