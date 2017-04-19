@pepBoys @debug

Feature: EXISTING ACCOUNT - DELIVERY METHOD

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("")
  Scenario: Cannot navigate on next Breadcrumbs (Existing User, Pay Online)
    Given user makes authorisation for "qa user"
    And user should be on "Billing & Shipping" tab
    And user presses "Delivery Method" breadcrumb tab
    And user presses "Payment & Review" breadcrumb tab
    Then user should be on "Billing & Shipping" tab




