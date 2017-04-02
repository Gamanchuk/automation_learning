@pepBoys @debug


Feature: Header and Footer (PayPal)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "PayPal" method


  @TestCaseId("15560")
  @TestCaseId("15562")
  @TestCaseId("15564")
  Scenario: Company Logo navigate to home page (Guest, PayPal, Payment & Review tab)
    And user confirms purchase with PayPal
    And chooses "Ground" shipping method
    And presses the "Continue" button
    And checks payment details for "qa user"
    And user checks support number with label "1-800-PEP-BOYS (737-2697)" and number "18007372697"
    And user checks text "© Copyright 2017 - The Pep Boys" in footer
    And user presses the logo
    Then user should be on main page