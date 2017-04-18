@pepBoys @MORE_debug

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15509")
  Scenario: Test with correct billing information and fill in all required fields (Add new address)
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enters a New Address"
    And user types billing info for "user at Spear street" and checks email
    And presses the "Continue" button

    And chooses "Use Recommended Address"
    And user should be on "Delivery Method" tab
    And presses the "Continue" button

    And user should be on "Payment & Review" tab
    Then user checks billing info for "user at Spear street"


