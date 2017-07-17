@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5848")
  @TestCaseId("15412")
  Scenario: Edit Shipping info
    Given user types billing info for "qa user"
    And user types shipping info for "qa user" without email, phone
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    And user clicks arrow for "Shipping Address"
    And user types manually shipping info for "qa user2" without email, phone
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And user checks shipping info for "qa user2"

