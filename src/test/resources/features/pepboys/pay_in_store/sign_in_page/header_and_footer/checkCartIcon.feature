@pepBoys 


Feature: PAY IN STORE - SIGN IN PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16691")
  Scenario: Check Cart icon
    Given user presses the signIn button
    And user presses the Shopping Cart icon
    Then user should be on cart page