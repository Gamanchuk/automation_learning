@pepBoys @debug

Feature: Sign In page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15535")
  Scenario: User can't sign in with empty "email address" and invalid "password" (Pay Online)
    Given user email "" password "invalid" makes authorisation
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
    