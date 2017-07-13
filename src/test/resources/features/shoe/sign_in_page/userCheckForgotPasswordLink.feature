@shoe

Feature: SIGN IN PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe

  @TestCaseId("16515")
  Scenario: User can click on Forgot Password link
    Given user presses the signIn button
    And user presses the Forgot Password link
    Then user should be on Shoe Forgot Password page
    