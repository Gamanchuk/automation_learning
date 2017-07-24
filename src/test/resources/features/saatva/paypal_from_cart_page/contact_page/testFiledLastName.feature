@saatva

Feature: EXPRESS PAYPAL CHECKOUT - CONTACT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal
    And user confirms purchase with PayPal
    And user should be on "Shipping" tab

  @TestCaseId("101936")
  Scenario: Test field 'Last name'
    Given user presses "Contact" breadcrumb tab
    And user should be on "Contact" tab

    And user types "" into the "Full Name" field
    And presses the "Continue" button
    Then user should stay at "Contact" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Moovweb !@#$%^&*())(*&^%$#@!" into the "Full Name" field
    And presses the "Continue" button
    Then user should be on "Shipping" tab
    And user navigates to "Contact" breadcrumb

    And user types "Moovweb 1" into the "Full Name" field
    And presses the "Continue" button
    Then user should be on "Shipping" tab
    And user navigates to "Contact" breadcrumb