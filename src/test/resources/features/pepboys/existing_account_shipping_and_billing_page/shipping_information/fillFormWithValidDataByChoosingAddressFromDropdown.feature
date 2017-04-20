@pepBoys

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15430")
  Scenario: Test with correct shipping information and fill in all required fields (Choose address from drop-down)
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address" for shipping address

    And applies shipping info for address "8th avenue, Unit 1611"
    And user checks shipping info for "qa user3"

    And presses the "Continue" button
    And user should be on "Delivery Method" tab
    And user checks shipping info for "qa user3"
    And presses the "Continue" button

    And user should be on "Payment & Review" tab
    Then user checks shipping info for "qa user3"


