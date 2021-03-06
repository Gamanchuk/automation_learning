@shoe

Feature: GUEST - SHIPPING PAGE - BILLING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    And user should be on "Payment" tab
    Then uses "mastercard" card for payment

  @TestCaseId("16349")
  Scenario: Test field 'Apartment'

    Given unset checkbox "Yes, billing address and shipping address are the same"
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



