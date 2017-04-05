@pepBoys @debug

Feature: PayPal - Delivery Method

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "PayPal" method
    And user confirms purchase as "qa user" with PayPal

  @TestCaseId("15553")
  Scenario: Breadcrumb links redirect user to correct page (PayPal)
    Given chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab

    Then user navigates to "Delivery Method" breadcrumb
    And user should be on "Delivery Method" tab









