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

  @TestCaseId("16820")
  Scenario: Test field 'Zip Code'

    Given unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user" without email

    And user types "" into the "Zip Code" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "94105" into the "Zip Code" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should be on "Review" tab
