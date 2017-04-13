@pepBoys @debug1


Feature: PayPal - Thank You Page

  Background:
    Given user makes appoint
    And user adds to cart any tires with "Installation" delivery option for "captiva"
    And user views cart
    And user schedules installation time
    And chooses "Pay Online" method

  @TestCaseId("15420")
  Scenario: Place Multiple Orders as exist user
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And uses PayPal for payment
    And user confirms purchase as "qa user" with PayPal
    Then user should be on thank you page
    And user presses the reschedule link