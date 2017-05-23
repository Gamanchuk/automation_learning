@pepBoys

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15509")
  Scenario: Test with correct billing information and fill in all required fields (Add new address manually)
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"

    And user types manually billing info for "user at Spear street" and checks email
    And presses the "Continue" button

    And chooses "Use Entered Address"

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    And user should be on "Payment & Review" tab
    Then user checks billing info for "user at Spear street" on thank you page


