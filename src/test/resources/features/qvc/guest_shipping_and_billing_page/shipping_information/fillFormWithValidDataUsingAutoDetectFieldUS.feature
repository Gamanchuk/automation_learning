@qvc @Ignored

Feature: GUEST - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102318")
  @TestCaseId("102322")
  Scenario: Test with correct shipping information and fill in all required fields (US Only)
    Given user types manually billing info for "qa user" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Delivery" tab


