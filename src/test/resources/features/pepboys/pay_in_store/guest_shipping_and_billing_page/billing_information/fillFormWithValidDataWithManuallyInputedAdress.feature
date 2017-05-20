@pepBoys @debug

Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16640")
  Scenario: Test with correct billing information and fill in all required fields (Address inputted manually)
    Given user types manually customer info for "qa user"
    And presses the "Continue" button
    Then user checks billing info for "qa user" on thank you page


