@pepBoys

Feature: EXISTING ACCOUNT - DELIVERY METHOD

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15491")
  Scenario: Breadcrumb links redirect user to correct page (Existing User, Pay Online, Payment -> Billing)
    Given user makes authorisation for "qa user"
    And applies billing info for address "201 SPEAR ST"
    And presses the "Continue" button
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    Then user navigates to "Billing & Shipping" breadcrumb









