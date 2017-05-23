@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15413")
  Scenario: Edit Billing info
    Given user types billing info for "qa user"
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    And user clicks arrow for "Billing Address"
    And user should be on "Billing & Shipping" tab

    And user types manually billing info for "qa user2"
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    Then user checks shipping info for "qa user2"
