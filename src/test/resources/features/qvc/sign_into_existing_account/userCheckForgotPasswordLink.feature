@pepBoys

Feature: SIGN IN PAGE

  Background:
    Given user adds to cart product


  @TestCaseId("102428")
  @TestCaseId("102434")
  Scenario: User can click on Forgot Password link
    Given user continue checkout as "qa user"
    And user presses the Forgot Password link
    Then user should be on QVC forgot password page
    