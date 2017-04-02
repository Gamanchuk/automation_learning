@pepBoys @debug


Feature: Header and Footer (Pay in Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16691")
  Scenario: Tap on icon "Shopping Cart" navigate to shopping cart page (Guest, Pay in Store, SignIn page)
    Given user presses the signIn button
    And user presses the Shopping Cart icon
    Then user should be on cart page