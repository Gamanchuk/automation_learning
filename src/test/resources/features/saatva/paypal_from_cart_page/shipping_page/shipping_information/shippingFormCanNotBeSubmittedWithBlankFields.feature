@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab

    #TODO: add state field method to set state field dropdown option to null
  @TestCaseId("101873")
  Scenario: Test with correct shipping information and do not fill in all required fields (error message should be displayed)
    And user types "" into the "Full Name" field of "Shipping Address" address form
    And user types "" into the "Street Address" field of "Shipping Address" address form
    And user types "" into the "Zip Code" field of "Shipping Address" address form
    And user types "" into the "Phone Number" field of "Shipping Address" address form
    And presses the "Continue" button
    And user should stay at "Shipping" tab
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    And unset checkbox "Yes, billing address and shipping address are the same"
    And presses the "Continue" button
    And user should stay at "Shipping" tab
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
