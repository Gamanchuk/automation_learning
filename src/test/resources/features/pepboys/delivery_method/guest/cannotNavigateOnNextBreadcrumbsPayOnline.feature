@pepBoys @debug

Feature: Guest - Delivery Method

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15367")
  Scenario: Cannot navigate on next Breadcrumbs (Guest, Pay Online)
    Given user should be on "Billing & Shipping" tab

    And user navigates to "Delivery Method" breadcrumb
    And user navigates to "Payment & Review" breadcrumb
    Then user should be on "Billing & Shipping" tab




