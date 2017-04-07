@pepBoys


Feature: Header and Footer (Pay Online)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15448")
  @TestCaseId("15450")
  @TestCaseId("15452")
  Scenario: Company Logo navigate to home page Company Logo navigate to home page (Existent user, Pay Online, Payment & Review tab)
    Given user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment
    And user checks support number with label "1-800-PEP-BOYS (737-2697)" and number "18007372697"
    And user checks text "© Copyright 2017 - The Pep Boys" in footer
    And user presses the logo
    Then user should be on main page

