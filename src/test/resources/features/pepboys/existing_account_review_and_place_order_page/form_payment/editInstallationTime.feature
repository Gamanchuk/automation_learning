@pepBoys

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart any tires with "Installation" delivery option for "captiva"
    And user views cart
    And user schedules installation time
    And chooses "Pay Online" method with appointment details

  @TestCaseId("15467")
  Scenario: Edit installation time
    Given user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button
    And user should be on "Payment & Review" tab

    And user checks installation time
    And user clicks arrow for "Installation"

    Then user should be on cart page
    And user updates installation time
    And chooses "Pay Online" method with appointment details
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    And user checks installation time




