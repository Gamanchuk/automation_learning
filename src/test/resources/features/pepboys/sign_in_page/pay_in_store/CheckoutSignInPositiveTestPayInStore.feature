@pepBoys

Feature: Sign In page (Pay in Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16678")
  Scenario: User can sign in with valid "email address" and valid "password" (Pay in Store)
    Given user makes authorisation for "qa user"
    Then user should be on "Billing" page
    