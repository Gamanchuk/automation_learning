@saatva

Feature: EXPRESS PAYPAL CHECKOUT - REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal
    And user should be on "Shipping" tab
    And user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab

  @TestCaseId("101195")
  Scenario: Check Edit Billing and Shipping Address
    Given user navigates to "Shipping" breadcrumb
    And user should be on "Shipping" tab
    #And user can expand and collapse Order summary

    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user2" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab
   # And user can expand and collapse Order summary


