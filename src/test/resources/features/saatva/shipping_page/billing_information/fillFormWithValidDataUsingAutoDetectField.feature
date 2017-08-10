@saatva

Feature: SHIPPING PAGE - BILLING INFO - DOMESTIC

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

  @Issues("MCCAT-6309")
  @TestCaseId("100979")
  @TestCaseId("101015")
  Scenario: Test with correct shipping information

    Given user types shipping address for "qa user" with phone number
    And unset checkbox "Yes, billing address and shipping address are the same"
    And presses the "Continue" button

    And user should stay at "Shipping" tab
    And user should see "United States" shipping country
    And chooses "Canada" country
    And user should see "Canada" shipping country
    And chooses "United States" country
    And user should see "United States" shipping country
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    #TODO: add country drop down selection for billing address form as well

    And user types billing info for "qa user" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab

