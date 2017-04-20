@pepBoys @debug

Feature: PAY IN STORE - EXISTING ACCOUNT - SHIPPING & BILLING PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16625")
  Scenario: Test with correct billing information and fill in all required fields (Add new address)
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"
    And user types billing info for "user at Spear street" and checks email
    And presses the "Continue" button

    And chooses "Use Recommended Address"
    And user should be on "Delivery Method" tab
    And presses the "Continue" button

    And user should be on "Payment & Review" tab
    Then user checks billing info for "user at Spear street"


