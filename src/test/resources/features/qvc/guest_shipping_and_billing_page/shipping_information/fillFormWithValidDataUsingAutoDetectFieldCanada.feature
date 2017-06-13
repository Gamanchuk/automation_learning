@qvc @ignore

Feature: GUEST - SHIPPING & BILLING ADDRESS PAGE

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab

  # Ship to Canada is unavailable
  @TestCaseId("102319")
  Scenario: Test with correct shipping information and fill in all existing fields
    Given chooses "Canada" country
    And user types manually international billing info for "qa canada" without email
    And user types shipping info for "qa canada"
    And presses the "Continue" button
    Then user checks shipping info for "qa canada"

