@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab

  @TestCaseId("101877")
  @TestCaseId("")
  Scenario: Test field 'Apartment'

    Given user types "" into the "Apt, Bldg." field of "Shipping Address" address form
    And user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab

    And user navigates to "Shipping" breadcrumb
    And user types "12345" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab

    And user navigates to "Shipping" breadcrumb
    And user types "Some Apartment" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab

    And user navigates to "Shipping" breadcrumb
    And user types "!#&@()" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab





