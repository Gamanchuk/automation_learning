@pepBoys @debug

Feature: Guest - Delivery Method

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16623")
  Scenario: Breadcrumb links redirect user to correct page (Guest, Pay in Store)
    Given user types billing info for "qa user"
    And presses the "Place Order" button
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab

    Then user navigates to "Delivery Method" breadcrumb
    And user should be on "Delivery Method" tab

    Then user navigates to "Billing & Shipping" breadcrumb
    And user should be on "Billing & Shipping" tab








