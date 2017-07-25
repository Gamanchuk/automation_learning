@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - BILLING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
   # And user confirms purchase as "qa user" with PayPal
    And user should be on "Shipping" tab

  @TestCaseId("101904")
  @TestCaseId("101905")
  @TestCaseId("101915")
  Scenario: Test with correct shipping information and do not fill in all required fields (error message should be displayed)
    Given user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And unset checkbox "Yes, billing address and shipping address are the same"
    And presses the "Continue" button

    And user should stay at "Shipping" tab
    Then sees "FORM ERRORS" error message with text "Please review all inputs."
