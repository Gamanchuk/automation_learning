@philosophy

Feature: GET STARTED PAGE - SIGN IN

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy


  @TestCaseId("82815")
  Scenario: User can sign in with valid email address and valid password
    Given user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
