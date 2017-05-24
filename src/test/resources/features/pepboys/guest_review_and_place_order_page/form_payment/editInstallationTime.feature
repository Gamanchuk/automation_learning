@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart any tires with "Installation" delivery option for "captiva"
    And user views cart
    And user schedules installation time
    And chooses "Pay Online" method with appointment details

  @TestCaseId("15415")
  Scenario: Edit installation time
    Given user types billing info for "qa user"
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    And user checks installation time
    And user clicks arrow for "Installation"

    Then user should be on cart page
    And user updates installation time
    And chooses "Pay Online" method with appointment details
    And presses the "Continue" button
    And user should be on "Payment & Review" tab
    And user checks installation time




