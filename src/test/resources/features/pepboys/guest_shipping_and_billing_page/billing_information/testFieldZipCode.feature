@pepBoys

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5848")
  @TestCaseId("15502")
  Scenario: Test field 'Zip Code'
    Given user types billing info for "qa user"
    And user types "" into the "Zip Code" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "94105" into the "Zip Code" field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks zip code with value "94105" on "Delivery Method" tab

    #We don't check billing info on Delivery page. Need to change option "Ship to Home" to "Pick up in store"
    #When you done first comment, please, change "Delivery Method" to "Payment and Review page"
    #It is line 35

