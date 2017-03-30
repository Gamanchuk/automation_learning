@pepBoys


Feature: Header and Footer

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("15368")
  Scenario: Company Logo navigate to home page (Pay In Store)

    # From Billing & Shipping tab (Guest User)
    And user press the logo
    Then user should be navigate to main page


    # From login page
    Given user navigates to cart page
    And chooses "Pay in Store" method
    And user press the signIn button
    And user checks support number with label "1-800-PEP-BOYS (737-2697)" and number "18007372697"
    And user checks text "© Copyright 2017 - The Pep Boys" in footer
    And user press the logo
    Then user should be navigate to main page

    Given user navigates to cart page
    And chooses "Pay in Store" method
    And user makes authorisation for "qa user"
    And user checks support number with label "1-800-PEP-BOYS (737-2697)" and number "18007372697"
    And user checks text "© Copyright 2017 - The Pep Boys" in footer
    And user press the logo
    Then user should be navigate to main page








