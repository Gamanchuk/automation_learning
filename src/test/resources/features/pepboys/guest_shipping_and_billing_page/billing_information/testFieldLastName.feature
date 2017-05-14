@pepBoys

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15497")
  Scenario: Test field 'Last name'
    Given user types billing info for "qa user"
    And user types "Moovweb" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Moovweb !@#&::!@#()" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Last Name is invalid"


    #Here I don't see positive case where user proceed to the next page and checks that Last name reflected correctly
    #We don't check billing info on Delivery page. Need to change option "Ship to Home" to "Pick up in store"
    #And check all billing information at Payment and review page

