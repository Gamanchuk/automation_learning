@pepBoys

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15510")
  Scenario: Test with correct billing information and fill in all required fields (Choose address from drop-down)
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And applies billing info for address "8th avenue, Unit 1611"
    And user checks billing info for "qa user3"

    And presses the "Continue" button
    And user should be on "Delivery Method" tab
    And presses the "Continue" button

    And user should be on "Payment & Review" tab
    Then user checks billing info for "qa user3"


