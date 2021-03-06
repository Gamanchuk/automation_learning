@pepBoys


Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5848")
  @TestCaseId("15429")
  Scenario: Test with correct shipping information and fill in all required fields (Add address manually)
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address" for shipping address

    And user types manually shipping info for "user at Spear street" without email, phone
    And presses the "Continue" button

    And chooses "Use Recommended Address"
    And user should be on "Delivery Method" tab
    Then user checks shipping info for "user at Spear street"



