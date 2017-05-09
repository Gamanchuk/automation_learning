@pepBoys

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15466")
  Scenario: Edit Billing Information
    Given user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button
    And user should be on "Payment & Review" tab

    And user clicks arrow for "Billing Address"
    And applies billing info for address "8th avenue, Unit 1611"
    And presses the "Continue" button

    Then user should be on "Payment & Review" tab
    And user checks billing info for "qa user3"
