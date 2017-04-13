@pepBoys @debug


Feature: Existing User - Thank You Page

  Background:
    Given user makes appoint
    And user adds to cart any tires with "Installation" delivery option for "captiva"
    And user views cart
    And user schedules installation time
    And chooses "Pay Online" method with appointment details

  @TestCaseId("15420")
  Scenario: Place Multiple Orders as exist user
    Given user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button
    And uses "visa" card for payment
    And presses the "Place Order" button
    And user should be on thank you page
    And user presses the reschedule link
