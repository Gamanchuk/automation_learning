@pepBoys 


Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "9423853" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16640")
  Scenario: Test with correct billing information and fill in all required fields (Address inputted manually)
    Given user types manually billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on thank you page
    Then user checks billing info for "qa user"


