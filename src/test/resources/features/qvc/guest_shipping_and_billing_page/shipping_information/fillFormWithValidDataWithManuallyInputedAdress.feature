@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102318")
  Scenario: Test with correct shipping information and fill in all required fields (Address input manually)

    Given user types manually billing info for "qa user" without email
    And user types manually shipping info for "qa user" without email, phone
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab



