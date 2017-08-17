@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab

  @Issues("MCCAT-6309")
  @TestCaseId("101906")
  @TestCaseId("")
  Scenario: Test field 'Name'
    Given user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user" without email

    And user types "" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    #This scenario is no longer valid test scenario due to how Name field is handled in Saatva
    #And user types "!@#&( !@#()" into the "Full Name" field of "Billing Address" address form
    #And presses the "Continue" button
    #Then user should stay at "Shipping" tab
    #And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mr Donal Trump III" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab
