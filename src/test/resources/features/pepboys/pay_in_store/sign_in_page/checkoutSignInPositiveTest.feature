@pepBoys 

Feature: PAY IN STORE - SIGN IN PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16678")
  Scenario: User can sign in with valid "email address" and valid "password"
    Given user makes authorisation for "qa user"
    Then user should be on "Customer Information" page
    