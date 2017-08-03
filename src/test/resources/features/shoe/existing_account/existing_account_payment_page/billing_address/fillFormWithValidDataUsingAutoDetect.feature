@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE - BILLING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And user types shipping info for "qa user" without email
    And unset checkbox "Save this address to my address book"
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses "visa" card for payment

  @TestCaseId("16812")
  @TestCaseId("16810")
  Scenario: Test with correct billing information and fill in all required fields

    Given unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Review" tab


