@saatva

Feature: SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    And presses the "Continue" button
    Then user should be on "Shipping" tab

  @TestCaseId("101031")
  Scenario: Test with correct shipping information and do not fill in all required fields (error message should be displayed)

    Given presses the "Continue" button
    And user should stay at "Shipping" tab
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
    And unset checkbox "Yes, billing address and shipping address are the same"
    And presses the "Continue" button
    And user should stay at "Shipping" tab
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
