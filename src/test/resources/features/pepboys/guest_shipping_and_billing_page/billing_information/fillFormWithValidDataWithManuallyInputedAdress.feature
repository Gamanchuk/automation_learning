@pepBoys

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5848")
  @TestCaseId("15493")
  Scenario: Test with correct billing information and fill in all required fields (Address inputted manually)
    Given user types manually billing info for "qa user"
    And presses the "Continue" button

    Then user should be on "Delivery Method" tab
    And user checks shipping info for "qa user"


