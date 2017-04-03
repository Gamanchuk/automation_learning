@pepBoys @debug

Feature: Sign In page (Pay Online)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15532")
  Scenario: User can't sign in with empty "email address" and "password" (Pay Online)
    Given user email "" password "" makes authorisation
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
    