@pepBoys

Feature: HAPPY PATH

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5505")
  @TestCaseId("16248")
  @TestCaseId("15373")
  Scenario: Place Order as a "Registered User" with Credit Card
    Given user makes authorisation for "qa user3"
    And applies billing info for address "8th avenue, Unit 1611"
    And user checks billing info for "qa user3"
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    And uses "visa" card for payment
    And user checks billing info for "qa user3"
    And presses the "Place Order" button

    Then user should be on thank you page
