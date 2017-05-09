@pepBoys

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15521")
  Scenario: Test field 'Phone'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"
    And user types billing info for "user at Spear street" and checks email

    And user types " " into the "Phone Number" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "#+*###" into the "Phone Number" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "4152011234" into the "Phone Number" field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks phone with value "4152011234" on "Payment & Review" tab

