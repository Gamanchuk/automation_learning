@pepBoys

Feature: Guest - Shipping & Billing page

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  # This Scenario is ignored, because we can check input values with Selenium
  # Invalid data will be filled into phone field


  @TestCaseId("15503")
  Scenario: Test field 'Phone'
    Given user types billing info for "qa user"
    And user types " " into the "Phone Number" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "phoneNumber" into the "Phone Number" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "!@$%^&*():_" into the "Phone Number" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "4152011234" into the "Phone Number" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
#    Then user checks "Phone" with value "4152011234" on "Delivery Method" tab

