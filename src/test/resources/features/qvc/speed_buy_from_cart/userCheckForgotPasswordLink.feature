@qvc

Feature: SPEED BUY FROM CART

  Background: Add product to card and process to checkout
    Given user adds to cart product and speed buy

  @TestCaseId("")
  Scenario: User can click on Forgot Password link
    Given user makes authorisation with "qa@automationQA.com" email and "" password
    And user presses the Forgot Password link
    Then user should be on QVC forgot password page
    