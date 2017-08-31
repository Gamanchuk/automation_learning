@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab

  @Issues("MCCAT-6309")
  @TestCaseId("101902")
  @TestCaseId("101918")
  Scenario: Test with correct shipping information and fill in all required fields (Address input manually)
    And user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And user types "123 mission st ste 1020" into the "Street Address" field of "Shipping Address" address form
    And unset checkbox "Yes, billing address and shipping address are the same"
    
    And user types manually billing info for "qa user2" without email


    #TODO: Create state field test for billing form
    #And user types "" into the "State" field of "Billing Address" address form
    #And presses the "Continue" button
    #And sees "FORM ERRORS" error message with text "Please review all inputs."
    #And user types "CA" into the "State" field of "Billing Address" address form


    #And selects "" state
    #And presses the "Continue" button
    #And sees "FORM ERRORS" error message with text "Please review all inputs."
    #And selects "CA" state
    #And presses the "Continue" button

    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab


