@pepBoys 

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15504")
  Scenario: Test field 'Email'
    Given user types billing info for "qa user"

    And user types "" into the email field
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "#######@moovweb.com" into the email field
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Email Address is invalid"

    And user types "qamoovweb.com" into the email field
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "123456@moovweb.com" into the email field
    And presses the "Continue" button
    Then user checks "Email" with value "123456@moovweb.com" on "Delivery Method" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "qa@moovweb" into the email field
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "qa@moovweb.com" into the email field
    And presses the "Continue" button
    Then user checks "Email" with value "qa@moovweb.com" on "Delivery Method" tab


    #We don't check billing info on Delivery page. Need to change option "Ship to Home" to "Pick up in store"
    #When you done first comment, please, change "Delivery Method" to "Payment and Review page"
    # It is lines 35, 46





