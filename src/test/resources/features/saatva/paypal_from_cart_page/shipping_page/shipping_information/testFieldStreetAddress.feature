@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab

  @TestCaseId("101876")
  @TestCaseId("")
  Scenario: Test field 'Address Street'

    Given user types "" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Mission Street" into the "Street Address" field of "Shipping Address" address form
    And user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab

    And user navigates to "Shipping" breadcrumb
    And user types "123456" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab

    And user navigates to "Shipping" breadcrumb
    And user types "!@$%^&*():_+" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab
