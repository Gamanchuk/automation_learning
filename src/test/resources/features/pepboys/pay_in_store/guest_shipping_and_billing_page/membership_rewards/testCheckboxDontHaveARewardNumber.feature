@pepBoys @debug

Feature: PAY IN STORE - GUEST - MEMBERSHIP REWARDS

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @Issue("MCCAT-5331")
  @TestCaseId("16658")
  Scenario: Test checkbox "Don't have a reward number"
    Given user types customer info for "qa user"
    And user chooses don't have a reward number
    And presses the "Place Order" button
    Then user should be on thank you page

#Finish this case after fix problem "MCCAT-5331"

