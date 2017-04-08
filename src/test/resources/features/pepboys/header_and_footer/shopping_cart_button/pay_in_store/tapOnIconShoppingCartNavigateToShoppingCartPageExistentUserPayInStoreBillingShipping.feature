@pepBoys

Feature: Header and Footer (Pay in Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16669")
  Scenario: Tap on icon Shopping Cart navigate to shopping cart page (Existent user, Pay in Store, Billing & Shipping tab)
    Given user makes authorisation for "qa user"
    And user should be on "Billing" page
    And user presses the Shopping Cart icon
    Then user should be on cart page








