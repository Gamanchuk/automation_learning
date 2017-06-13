@qvc

Feature: GUEST - SHIPPING & BILLING ADDRESS PAGE

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102318")
  Scenario: Test with correct shipping information and fill in all required fields (Address input manually)

    Given user types manually billing info for "qa user"
    And user types manually shipping info for "qa user"
    And presses the "Continue" button

    Then user should be on "Delivery Method" tab
    And user checks shipping info for "qa user"


