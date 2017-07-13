@shoe

Feature: SIGN IN PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe


  @TestCaseId("16506")
  @TestCaseId("16507")
  Scenario: User can sign in with valid email address and valid password
    Given user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    