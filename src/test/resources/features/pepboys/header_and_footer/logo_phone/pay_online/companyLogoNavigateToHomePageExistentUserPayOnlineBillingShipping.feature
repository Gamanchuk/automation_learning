@pepBoys @debug


Feature: Header and Footer (Pay Online)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15424")
  @TestCaseId("15426")
  @TestCaseId("15428")
  Scenario: Company Logo navigate to home page Company Logo navigate to home page (Existent user, Pay Online, Billing & Shipping tab)
    Given user makes authorisation for "qa user"
    And user should be on "Billing & Shipping" page
    And user checks support number with label "1-800-PEP-BOYS (737-2697)" and number "18007372697"
    And user checks text "© Copyright 2017 - The Pep Boys" in footer
    And user presses the logo
    Then user should be on main page
