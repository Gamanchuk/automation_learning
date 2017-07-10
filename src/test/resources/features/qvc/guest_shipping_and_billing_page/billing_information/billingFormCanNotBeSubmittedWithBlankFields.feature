@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO - DOMESTIC

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102388")
  Scenario: Test with do not fill all required fields

    When presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

