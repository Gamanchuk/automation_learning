@pepBoys @refactoring


Feature: Membership Rewards

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15390")
  Scenario: Test field "Rewards" when user enter Invalid Rewards Account
    Given user types billing info for "qa user"
    And user types rewards number "1212"
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "The Rewards Number you provided is not in the correct format."

    And user types rewards number "someText"
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "The Rewards Number you provided is not in the correct format."

    And user types rewards number "!@#$%^&*$$()"
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "The Rewards Number you provided is not in the correct format."

    And user types rewards number ""
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks billing info for "qa user"
