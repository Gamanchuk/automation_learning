@pepBoys @debug

Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "787233" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16641")
  Scenario: Test with correct billing information and fill in all required fields (Address chosen from auto-detect drop-down)
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And user should be on thank you page
    Then user checks billing info for "qa user"


