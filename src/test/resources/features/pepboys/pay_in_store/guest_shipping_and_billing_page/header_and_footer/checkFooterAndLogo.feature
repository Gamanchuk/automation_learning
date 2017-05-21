@pepBoys 


Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16693")
  @TestCaseId("16695")
  @TestCaseId("16697")
  Scenario: Check footer and logo
    Given user checks support number with label "1-800-PEP-BOYS (737-2697)" and number "18007372697"
    And user checks text "© Copyright 2017 - The Pep Boys" in footer
    And user presses the logo
    Then user should be on main page