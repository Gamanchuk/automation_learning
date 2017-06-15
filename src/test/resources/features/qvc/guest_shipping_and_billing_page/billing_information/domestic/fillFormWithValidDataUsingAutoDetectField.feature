@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO - DOMESTIC

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102392")
  @TestCaseId("102406")
  Scenario: Test with correct billing information and fill in all existing fields (Address chosen from dropdown of auto-detect)
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email
    And user chooses "Miss" title
    And presses the "Continue" button
    Then user should be on "Delivery" tab

