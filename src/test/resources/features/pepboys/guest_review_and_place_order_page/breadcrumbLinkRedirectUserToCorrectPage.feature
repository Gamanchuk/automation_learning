@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15394")
  Scenario: Breadcrumb links redirect user to correct page.
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    Then user should be on "Payment & Review" tab

    And user navigates to "Billing & Shipping" breadcrumb
    Then user should see "Billing Address" form
