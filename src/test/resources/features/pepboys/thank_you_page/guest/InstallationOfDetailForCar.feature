@pepBoys


Feature: GUEST - THANK YOU PAGE

  Background:
    Given user makes appoint
    And user adds to cart any tires with "Installation" delivery option for "captiva"
    And user views cart
    And user schedules installation time
    And chooses "Pay Online" method with appointment details

  @TestCaseId("15420")
  Scenario: Installation of detail for car
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And uses "visa" card for payment
    And presses the "Place Order" button
    Then user should be on thank you page
    And user presses the reschedule link
