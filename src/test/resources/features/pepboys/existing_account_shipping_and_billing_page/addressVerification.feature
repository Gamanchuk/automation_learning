@pepBoys


Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - ADDRESS VERIFICATION

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15540")
  Scenario: Check Address verification

    Given user makes authorisation for "qa user"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"

    And user types manually billing info for "qa user" and checks email
    And user types "10th floor" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Edit Address"
    Then user should stay at "Billing & Shipping" tab

    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery Method" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And presses the "Continue" button
    And chooses "Use Recommended Address"
    Then user should be on "Delivery Method" tab







