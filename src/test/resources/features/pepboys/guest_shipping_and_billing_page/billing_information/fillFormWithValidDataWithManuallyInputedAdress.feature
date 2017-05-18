@pepBoys

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15493")
  Scenario: Test with correct billing information and fill in all required fields (Address inputted manually)
    Given user types manually billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks billing info for "qa user"

    #We don't check billing info on Delivery page. Need to change option "Ship to Home" to "Pick up in store"

