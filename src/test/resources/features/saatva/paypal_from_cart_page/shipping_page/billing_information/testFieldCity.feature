@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab

  @Issues("MCCAT-6309")
  @TestCaseId("101910")
  @TestCaseId("")
  Scenario: Test field 'City'
    Given user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user" without email

    And user types "" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "SanFrancisco" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab

    And user navigates to "Shipping" breadcrumb
    And user types "123456" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab

    And user navigates to "Shipping" breadcrumb
    And user types "!@$%^&*():_+" into the "City" field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab

