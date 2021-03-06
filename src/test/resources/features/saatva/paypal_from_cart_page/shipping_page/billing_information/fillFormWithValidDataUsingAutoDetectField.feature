@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab

  @Issues("MCCAT-6309")
  @TestCaseId("101903")
  @TestCaseId("101918")
  Scenario: Test with correct shipping information and do not fill in all required fields (error message should be displayed)
    And user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And user types "123 mission st ste 1020" into the "Street Address" field of "Shipping Address" address form
    And unset checkbox "Yes, billing address and shipping address are the same"
    And presses the "Continue" button

    And user should stay at "Shipping" tab
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
    
    And user types billing info for "qa user2" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab

