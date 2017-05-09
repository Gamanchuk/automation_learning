@pepBoys

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5505")
  @TestCaseId("15422")
  Scenario: Links at Thank you page
    Given user makes authorisation for "qa user"
    And applies billing info for address "201 SPEAR ST"
    And presses the "Continue" button

    And user should be on "Payment & Review" tab
    And uses "visa" card for payment
    And presses the "Place Order" button
    And user should be on thank you page
    Then user presses the Find out more link
    And user should be on rewards page
