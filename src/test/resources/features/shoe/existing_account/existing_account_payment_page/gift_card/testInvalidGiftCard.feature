@shoe @Ignored

Feature: EXISTING ACCOUNT - PAYMENT PAGE - GIFT CARD

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And user types shipping info for "qa user" without email
    And unset checkbox "Save this address to my address book"
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment


  @TestCaseId("16826")
  Scenario: Test field "Gift Card" when user enter Invalid Gift Card


    Given user types gift card with ":?%:%:%;№%;№)(*" number and "0285" pin code
    And presses the "Apply" button
    Then sees "ERROR" error message with text "Your gift card cannot be validated, missing or invaild account number/pin"
    And presses the OK, I'll Try Again button
    And user should be on "Payment" tab

    And user types gift card with "aasdasdasd" number and "0285" pin code
    And presses the "Apply" button
    Then sees "ERROR" error message with text "Your gift card cannot be validated, missing or invaild account number/pin"
    And presses the OK, I'll Try Again button

    And user types gift card with "aasdasdasd" number and "qweq" pin code
    And presses the "Apply" button
    Then sees "ERROR" error message with text "Your gift card cannot be validated, missing or invaild account number/pin"
    And presses the OK, I'll Try Again button