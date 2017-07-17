@shoe

Feature: GUEST - SHIPPING PAGE - SHIPPING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe


  @TestCaseId("16290")
  Scenario: Test field 'Email'
    Given user types shipping info for "qa user"

    And user types "" into the email field
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "qamoovweb.com" into the email field
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "qa@moovweb" into the email field
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "123456@moovweb.com" into the email field
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And user navigates to "Shipping" breadcrumb

    And user types "qa@moovweb.com" into the email field
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And user navigates to "Shipping" breadcrumb

    And user types "#######@moovweb.com" into the email field
    And presses the "Continue" button
    Then user should be on "Payment" tab








