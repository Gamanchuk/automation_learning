@pepBoys

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15400")
  @Issue("MCCAT-5505")
  Scenario: Test with correct Discover billing information and fill in all required fields
    Given user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button

    And uses "discover" card for payment
    And presses the "Place Order" button
    Then user should be on thank you page
