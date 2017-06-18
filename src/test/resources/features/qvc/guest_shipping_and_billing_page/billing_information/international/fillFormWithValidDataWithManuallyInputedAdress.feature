@qvc @Ignored

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO - INTERNATIONAL

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102388")
  Scenario: Test with correct billing information and fill in all required fields (Address inputted manually)
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And chooses "Canada" country
    And user types manually international billing info for "qa canada" without email

    And user types domestics shipping info for "qa user" without phone
    And presses the "Continue" button
    Then user should be on "Delivery" tab


