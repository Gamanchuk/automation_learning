@pepBoys

Feature: PAY IN STORE - GUEST - MEMBERSHIP REWARDS

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16657")
  Scenario: Test field "Rewards" when user enter Invalid Rewards Account
    Given user types billing info for "qa user"

    And user types rewards number "1212"
    And presses the "Place Order" button
    Then user should be on "Billing" page
    And sees "FORM ERRORS" error message with text "The Rewards Number you provided is not in the correct format."

    And user types rewards number "someText"
    And presses the "Place Order" button
    Then user should be on "Billing" page
    And sees "FORM ERRORS" error message with text "The Rewards Number you provided is not in the correct format."

    And user types rewards number "!@#$%^&*$$()"
    And presses the "Place Order" button
    Then user should be on "Billing" page
    And sees "FORM ERRORS" error message with text "The Rewards Number you provided is not in the correct format."

    And user types rewards number ""
    And presses the "Place Order" button
    Then user should be on thank you page
