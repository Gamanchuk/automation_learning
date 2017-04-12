@pepBoys @debug1


Feature: PayPal - Thank You Page

  Background:
    Given user makes appoint
    And user adds to cart any tires with "Installation" delivery option for "captiva"
    And user views cart
    And user schedules installation time
    And chooses "PayPal" method with appointment details

  @TestCaseId("15420")
  Scenario: Place Multiple Orders as exist user
    Given chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And checks payment details for "qa user"
    And presses the "Place Order" button
    Then user should be on thank you page
    And user presses the reschedule link
