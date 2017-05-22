@pepBoys @debug

Feature: EXISTING ACCOUNT - DELIVERY METHOD PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15482")
  Scenario: Tap on icon Shopping Cart navigate to shopping cart page (Existent user, Pay Online, Delivery Method tab)
    Given user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button
    And user should be on "Delivery Method" tab
    And user presses the Shopping Cart icon
    Then user should be on cart page
