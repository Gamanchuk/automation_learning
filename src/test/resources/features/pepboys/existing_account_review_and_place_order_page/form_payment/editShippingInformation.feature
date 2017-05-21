@pepBoys

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15465")
  Scenario: Test Shipping Information
    Given user makes authorisation for "qa user3"
    And applies shipping info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And user should be on "Payment & Review" tab

    And user clicks arrow for "Shipping Address"
    And applies shipping info for address "8th avenue, Unit 1611"
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    Then user should be on "Payment & Review" tab
    And user checks shipping info for "qa user3"



