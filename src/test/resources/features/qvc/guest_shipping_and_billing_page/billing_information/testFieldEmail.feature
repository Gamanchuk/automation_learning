@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO - DOMESTIC

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    Then user types manually billing info for "qa user" without email

  @TestCaseId("102403")
  Scenario: Test field 'Email'

    When user types "" into the email field
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    When user types "qamoovweb.com" into the email field
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    When user types "123456@moovweb.com" into the email field
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    When user types "#######@moovweb.com" into the email field
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab
    And user navigates to "Address" breadcrumb

    When user types "qa@moovweb" into the email field
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    When user types "qa@moovweb.com" into the email field
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab







