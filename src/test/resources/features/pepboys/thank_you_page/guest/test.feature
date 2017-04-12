@pepBoys @debug1


Feature: Guest - Thank You Page

  Background:
    Given user makes appoint
    And user adds to cart any tires with "Installation" delivery option for "captiva"
    And user views cart
    And user schedules installation time
    And chooses "Pay Online" method with appointment details

  @TestCaseId("")
  Scenario: Place Multiple Orders as exist user
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And uses "visa" card for payment
    And presses the "Place Order" button
    Then user should be on thank you page
