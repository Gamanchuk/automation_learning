@saatva @debug

Feature: SHIPPING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

  @Issues("MCCAT-6309")
  @TestCaseId("100978")
  @TestCaseId("101015")
  @TestCaseId("100987")
  Scenario: Test with correct shipping information and fill in all required fields (Address input manually)

    Given user types shipping address for "qa user" with phone number
    And unset checkbox "Yes, billing address and shipping address are the same"
    
    And user types manually billing info for "qa user" without email
    And selects "" state
    And presses the "Continue" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
    And selects "CA" state
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab


