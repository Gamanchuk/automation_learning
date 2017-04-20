@pepBoys @debug  @ignore

Feature: PAY IN STORE - EXISTING ACCOUNT - SHIPPING & BILLING PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  # This Scenario is ignored, because we can check input values with Selenium
  # Invalid data will be filled into phone field


  @TestCaseId("16637")
  Scenario: Test field 'Phone'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"
    And user types billing info for "user at Spear street" and checks email

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

