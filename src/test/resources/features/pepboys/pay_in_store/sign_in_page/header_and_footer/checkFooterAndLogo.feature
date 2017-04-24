@pepBoys


Feature: PAY IN STORE - SIGN IN PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16689")
  @TestCaseId("16691")
  @TestCaseId("16692")
  Scenario: Check footer and logo
    Given user presses the signIn button
    And user checks support number with label "1-800-PEP-BOYS (737-2697)" and number "18007372697"
    And user checks text "© Copyright 2017 - The Pep Boys" in footer
    And user presses the logo
    Then user should be on main page