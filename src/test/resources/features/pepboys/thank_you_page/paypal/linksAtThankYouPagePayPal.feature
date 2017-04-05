@pepBoys

Feature: Existing User - Thank You Page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "PayPal" method
    And user confirms purchase as "qa user" with PayPal

  @TestCaseId("15570")
  Scenario: Links at Thank you page (PayPal)
    Given chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And checks payment details for "qa user"
    And presses the "Place Order" button
    And user should be on thank you page
    Then user presses the Find out more link
    And user should be on rewards page

