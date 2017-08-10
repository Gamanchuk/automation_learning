@saatva

Feature: SHIPPING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

  @TestCaseId("102576")
  @TestCaseId("100980")
  @TestCaseId("100981")
  @TestCaseId("100992")
  @TestCaseId("101069")
  Scenario: Test with correct shipping information and do not fill in all required fields (error message should be displayed)

    Given user types shipping address for "qa user" with phone number
    And unset checkbox "Yes, billing address and shipping address are the same"
    And presses the "Continue" button

    And user should stay at "Shipping" tab
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
