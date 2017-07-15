@saatva

Feature: SHIPPING PAGE - Billing Info - Domestic

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

  @Issues("MCCAT-6309")
  @TestCaseId("100979")
  @TestCaseId("101015")
  Scenario: Test with correct shipping information and do not fill in all required fields (error message should be displayed)
    Given user types shipping address for "qa user" with phone number
    And unset checkbox "Yes, billing address and shipping address are the same"
    And presses the "Continue" button

    And user should stay at "Shipping" tab
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
    
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab

