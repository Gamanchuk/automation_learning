@pepBoys

Feature: Sign In page (Pay Online)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15527")
  Scenario: User can return to Guest Checkout (Pay Online)
    Given user presses the signIn button
    And user presses the Proceed to Guest Checkout link
    Then user should be on "Billing & Shipping" tab