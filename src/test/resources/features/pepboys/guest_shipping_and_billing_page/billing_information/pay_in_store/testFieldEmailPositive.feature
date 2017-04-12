@pepBoys @debug

Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "627463" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16651")
  Scenario Outline: Test field 'Email' Positive
    Given user types billing info for "qa user"
    And user types "<email>" into the email field
    And presses the "Place Order" button
    Then user should be on thank you page
    And user checks "Email" with value "<email>" on thank you page
    And clean up cart

    Examples:
      | email              |
      | 123456@moovweb.com |
      | qa@moovweb.com     |





