@pepBoys 

Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "627494" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16651")
  Scenario: Test field 'Email' Negative
    Given user types billing info for "qa user"
    And user types "" into the email field
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "#######@moovweb.com" into the email field
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Email Address is invalid"

    And user types "qamoovweb.com" into the email field
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "qa@moovweb" into the email field
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."