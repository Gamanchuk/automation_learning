@pepBoys

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15514")
  Scenario: Test field 'Name'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"
    And user types billing info for "qa user" and checks email

    And user types " " into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@#&( !@#()" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mr Donal Trump III" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks "Full Name" with value "Mr Donal Trump III" on "Delivery Method" tab
