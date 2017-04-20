@pepBoys @debug

Feature: PAY IN STORE - EXISTING ACCOUNT - SHIPPING & BILLING PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16636")
  Scenario: Test field 'Zip Code'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"
    And user types billing info for "qa user" and checks email

    And user types "" into the "Zip Code" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should stay at "Billing & Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

#    And user types "zipCode" into the "Zip Code" field of "Billing Address" form
#    And presses the "Continue" button
#    And chooses "Use Entered Address"
#    Then user should stay at "Billing & Shipping" tab
#    And sees "FORM ERRORS" error message with text "ZIP Code is invalid (xxxxx or xxxxx-xxxx)"
#
#    And user types "!@$%^&*():_+" into the "Zip Code" field of "Billing Address" form
#    And presses the "Continue" button
#    And chooses "Use Entered Address"
#    Then user should stay at "Billing & Shipping" tab
#    And sees "FORM ERRORS" error message with text "ZIP Code is invalid (xxxxx or xxxxx-xxxx)"

    And user types "94105" into the "Zip Code" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user checks zip code with value "94105" on "Delivery Method" tab
