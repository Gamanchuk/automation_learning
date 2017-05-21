@pepBoys

Feature: PAY IN STORE - SIGN IN PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16686")
  Scenario: User can click on Forgot Password link
    Given user presses the signIn button
    And user presses the Forgot Password link
    Then user should be on Forgot Password page
    