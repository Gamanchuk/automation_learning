@pepBoys

Feature: GUEST - DELIVERY METHOD

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15367")
  Scenario: Cannot navigate on next Breadcrumbs (Guest, Pay Online)
    Given user should be on "Billing & Shipping" tab
    And user presses "Delivery Method" breadcrumb tab
    And user presses "Payment & Review" breadcrumb tab
    Then user should be on "Billing & Shipping" tab




