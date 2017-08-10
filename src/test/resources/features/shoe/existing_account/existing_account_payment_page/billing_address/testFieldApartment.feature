@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE - BILLING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment

  @TestCaseId("16817")
  Scenario: Test field 'Apartment'
    Given selects "Enter a New Address" for billing address
    And user types billing info for "qa user" without email

    And user types "" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user should be on "Review" tab
    And user navigates to "Payment" breadcrumb
    And user fills "CVV" field from "visa" card

    And user types "12345" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Review" tab
    And user navigates to "Payment" breadcrumb
    And user fills "CVV" field from "visa" card

    And user types "Some Apartment" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user should be on "Review" tab
    And user navigates to "Payment" breadcrumb
    And user fills "CVV" field from "visa" card

    And user types "!#&@()" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Review" tab



