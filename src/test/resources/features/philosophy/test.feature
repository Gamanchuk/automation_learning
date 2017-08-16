@philosophy @debug

Feature: SIGN IN PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest


  @TestCaseId("16514")
  Scenario: User can't sign in with incorrect/invalid/empty email address and password


