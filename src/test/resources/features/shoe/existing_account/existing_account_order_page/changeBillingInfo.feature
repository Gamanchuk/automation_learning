@shoe

Feature: EXISTING ACCOUNT - ORDER REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment
    And user fills "CVV" field from "visa" card
    And presses the "Continue" button
    Then user should be on "Review" tab


  @TestCaseId("16829")
  Scenario: Change billing address

    Given user clicks arrow for "Billing Address"
    And user should be on "Payment" tab
    And user fills "CVV" field from "visa" card
    And unset checkbox "Yes, billing address and shipping address are the same"
    And applies billing info for address "201 Spear St"
    And presses the "Continue" button
    Then user should be on "Review" tab




