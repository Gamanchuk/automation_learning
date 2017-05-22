@pepBoys

Feature: GUEST - BREADCRUMB

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15489")
  @TestCaseId("15394")
  @TestCaseId("15367")
  Scenario: Breadcrumb links redirect user to correct page
    Given user types billing info for "qa user"

    And user presses "Delivery Method" breadcrumb tab
    And user presses "Payment & Review" breadcrumb tab
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And user presses "Payment & Review" breadcrumb tab
    And user navigates to "Billing & Shipping" breadcrumb
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    And user should be on "Payment & Review" tab
    Then user navigates to "Delivery Method" breadcrumb
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    And user navigates to "Billing & Shipping" breadcrumb









