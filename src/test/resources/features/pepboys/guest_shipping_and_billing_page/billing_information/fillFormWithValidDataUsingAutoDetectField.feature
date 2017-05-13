@pepBoys

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15494")
  Scenario: Test with correct billing information and fill in all required fields (Address chosen from auto-detect drop-down)
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    Then user checks billing info for "qa user"

    #We don't check billing info on Delivery page. Need to change option "Ship to Home" to "Pick up in store"


