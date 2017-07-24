@saatva

Feature: EXPRESS PAYPAL CHECKOUT - CONTACT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal
    And user confirms purchase with PayPal
    And user should be on "Shipping" tab

  @TestCaseId("101938")
  Scenario: Test field 'Email'
    Given user presses "Contact" breadcrumb tab
    And user should be on "Contact" tab

    And user fills email field with ""
    And presses the "Continue" button
    Then user should stay at "Contact" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user fills email field with "q"
    And presses the "Continue" button
    Then user should stay at "Contact" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user fills email field with "%$^%$%$^$%$@#$%()@gmail.com"
    And presses the "Continue" button
    Then user should stay at "Contact" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user fills email field with "qa@sdfsadfdsfdsgdfsgdsfgfdgdfsbvgbdfskjghdfjkghdfshjgbdfjkhsgb"
    And presses the "Continue" button
    Then user should stay at "Contact" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user fills email field with "qa@moovweb.com"
    And presses the "Continue" button
    Then user should be on "Shipping" tab
    And user navigates to "Contact" breadcrumb

    And user fills email field with "12345@gmail.com"
    And presses the "Continue" button
    Then user should be on "Shipping" tab

