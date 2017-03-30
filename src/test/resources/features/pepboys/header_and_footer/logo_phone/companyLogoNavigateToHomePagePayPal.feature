@pepBoys


Feature: Header and Footer

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "PayPal" method


  @TestCaseId("15368")
  Scenario: Company Logo navigate to home page (PayPal)

    #From Delivery Method tab (PayPal)
    And user confirms purchase as "qa user" with PayPal
    And chooses "Ground" shipping method
    And user checks support number with label "1-800-PEP-BOYS (737-2697)" and number "18007372697"
    And user checks text "© Copyright 2017 - The Pep Boys" in footer
    And user press the logo
    Then user should be navigate to main page

    #From Payment & Review tab (PayPal)
    Given user navigates to cart page
    And chooses "PayPal" method
    And user confirms purchase with PayPal
    And chooses "Ground" shipping method
    And presses the "Continue" button
    And checks payment details for "qa user"
    And user checks support number with label "1-800-PEP-BOYS (737-2697)" and number "18007372697"
    And user checks text "© Copyright 2017 - The Pep Boys" in footer
    And user press the logo
    Then user should be navigate to main page