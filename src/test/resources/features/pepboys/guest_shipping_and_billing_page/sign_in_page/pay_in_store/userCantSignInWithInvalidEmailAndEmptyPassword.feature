@pepBoys

Feature: Sign In page (Pay in Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16685")
  Scenario: User can't sign in with invalid "email address" and empty "password" (Pay in Store)
    Given user makes authorisation with "notqa@moovweb.com" email and "" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
    