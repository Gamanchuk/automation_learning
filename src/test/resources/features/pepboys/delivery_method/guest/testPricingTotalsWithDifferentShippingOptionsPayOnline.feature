@pepBoys @debug

Feature: Guest - Delivery Method

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15490")
  Scenario: Test Pricing Totals with different shipping options (Guest)
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    And user checks "Ground: 5-7 Days" shipping method
    And user navigates to "Delivery Method" breadcrumb

    And chooses "Expedited: 2 Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    And user checks "Expedited: 2 Days" shipping method
    And user navigates to "Delivery Method" breadcrumb

    And chooses "Expedited: 3 Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    And user checks "Expedited: 3 Days" shipping method
    And user navigates to "Delivery Method" breadcrumb

    And chooses "Next Day: 1 Day" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    And user checks "Next Day: 1 Day" shipping method








