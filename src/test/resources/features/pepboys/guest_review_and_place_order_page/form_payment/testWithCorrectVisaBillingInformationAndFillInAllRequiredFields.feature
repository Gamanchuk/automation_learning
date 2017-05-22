@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5505")
  @TestCaseId("15400")
  Scenario: Test with correct Visa billing information and fill in all required fields
    Given user types billing info for "qa user"
    And presses the "Continue" button

    And uses "visa" card for payment
    And presses the "Place Order" button
    Then user should be on thank you page
