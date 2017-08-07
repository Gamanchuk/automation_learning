@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE - BILLING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment

  @TestCaseId("16812")
  @TestCaseId("16810")
  Scenario: Test with correct billing information and fill in all required fields

    Given selects "Enter a New Address" for billing address
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Review" tab


