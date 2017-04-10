@pepBoys

Feature: Existing User - Delivery Method

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15492")
  Scenario: Test Pricing Totals with different shipping options (Existing User)
    Given user makes authorisation for "qa user"
    And applies billing info for address "201 SPEAR ST"
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    And user checks "Ground: 5-7 Days" shipping method
    And user navigates to "Delivery Method" breadcrumb
    And user should be on "Delivery Method" tab

    And chooses "Expedited: 2 Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    And user checks "Expedited: 2 Days" shipping method
    And user navigates to "Delivery Method" breadcrumb
    And user should be on "Delivery Method" tab

    And chooses "Expedited: 3 Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    And user checks "Expedited: 3 Days" shipping method
    And user navigates to "Delivery Method" breadcrumb
    And user should be on "Delivery Method" tab

    And chooses "Next Day: 1 Day" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    And user checks "Next Day: 1 Day" shipping method







