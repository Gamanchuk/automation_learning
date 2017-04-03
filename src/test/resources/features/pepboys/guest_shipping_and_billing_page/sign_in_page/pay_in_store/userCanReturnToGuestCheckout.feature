@pepBoys @debug

Feature: Sign In page (Pay in Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16676")
  Scenario: User can return to Guest Checkout (Pay in Store)
    Given user presses the signIn button
    And user presses the Proceed to Guest Checkout link
    Then user should be on "Billing & Shipping" tab