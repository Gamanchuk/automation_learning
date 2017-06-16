@qvc @Ignored 

Feature: GUEST - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102319")
  Scenario: Test with correct shipping information and fill in all existing fields
    Given chooses "Canada" country
    And user types billing info for "qa canada" without email
    And user types international shipping info for "qa user"
    And presses the "Continue" button
    And user should be on "Delivery" tab

