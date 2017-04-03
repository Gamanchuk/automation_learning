@pepBoys @debug

Feature: Sign In page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16682")
  Scenario: User can't sign in with empty "email address" and valid "password" (Pay in Store)
    Given user email "" password "Spear201!" makes authorisation
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
    