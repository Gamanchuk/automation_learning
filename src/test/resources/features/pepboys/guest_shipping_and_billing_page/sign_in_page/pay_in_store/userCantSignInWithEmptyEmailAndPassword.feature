@pepBoys @debug

Feature: Sign In page (Pay in Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16681")
  Scenario: User can't sign in with empty "email address" and "password" (Pay in Store)
    Given user email "" password "" makes authorisation
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
    