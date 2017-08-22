@qvc @Ignored

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO - DOMESTIC

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab


  @TestCaseId("102392")
  @TestCaseId("102406")
  Scenario: Test with correct billing information and fill in all existing fields (Address chosen from dropdown of auto-detect)

    When user chooses "Miss" title
    And user types manually billing info for "qa user" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab

