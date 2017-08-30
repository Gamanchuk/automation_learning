@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102320")
  @TestCaseId("102321")
  Scenario: Test with correct shipping information and do not fill in all required fields (error message should be displayed)
    Given user types manually billing info for "qa user" without email
    And unset checkbox "Yes, shipping address and billing address are the same"
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."



