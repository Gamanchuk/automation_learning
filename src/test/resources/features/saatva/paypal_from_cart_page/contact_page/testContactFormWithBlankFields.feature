@saatva

Feature: EXPRESS PAYPAL CHECKOUT - CONTACT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab

  @TestCaseId("101937")
  Scenario: Test contact form with blank fields (error message should be displayed)
    Given user presses "Contact" breadcrumb tab
    And user should be on "Contact" tab
    
    And user types "" into the "Full Name" field
    And user fills email field with ""
    And presses the "Continue" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."