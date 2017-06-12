@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO - DOMESTIC

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("")
  Scenario: Test with correct billing information and fill in all required fields (Address inputted manually)
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types manually billing info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Delivery" tab



