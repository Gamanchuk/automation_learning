@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab

  @Issues("MCCAT-6309")
  @TestCaseId("101907")
  @TestCaseId("101914")
  Scenario: Test field 'Last name'
    And user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And user types "123 mission st ste 1020" into the "Street Address" field of "Shipping Address" address form
    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user2" without email

    And user types "Moovweb" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "qa qwertyuioplkjhgfdsazxcvbnm" into the "Full Name" field of "Shipping Address" address form
    And user types "Moovweb qa" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab
    And user presses "Shipping" breadcrumb tab
    Then user should be on "Shipping" tab

    And user types "Moovweb !@#&::!@#()" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab



