@pepBoys

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("91891")
  Scenario: Test with chosen billing address from saved addresses of drop-down
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab

    And applies shipping info for address "8th avenue, Unit 1611"
    And user checks shipping info for "qa user3"

    And presses the "Continue" button
    And user should be on "Delivery Method" tab
    Then user checks shipping info for "qa user3"

    # Need to change at title Scenario from "billing" to "shipping"
