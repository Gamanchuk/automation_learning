@pepBoys

Feature: SIGN IN PAGE

  Background:
    Given user adds to cart product


  @TestCaseId("102420")
  Scenario: User can sign in with valid email address and valid password
    Given user continue checkout as "qa user"
    And presses the "Continue" button
    Then user should be on "Address" tab