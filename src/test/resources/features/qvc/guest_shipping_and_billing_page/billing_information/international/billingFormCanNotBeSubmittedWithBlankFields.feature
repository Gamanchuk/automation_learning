@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO - INTERNATIONAL

  Background:
    Given user adds to cart product

  @TestCaseId("102388")
  Scenario: Test with do not fill all required fields
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And chooses "Canada" country

    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

