@pepBoys @debug

Feature: Existing User - Delivery Method

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("")
  Scenario: Cannot navigate on next Breadcrumbs (Existing User, Pay Online)
    Given user makes authorisation for "qa user"
    And user should be on "Billing & Shipping" tab
    And user navigates to "Delivery Method" breadcrumb
    And user navigates to "Payment & Review" breadcrumb
    Then user should be on "Billing & Shipping" tab




