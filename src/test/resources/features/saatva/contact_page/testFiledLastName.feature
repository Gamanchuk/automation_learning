@saatva

Feature: CONTACT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page

  @TestCaseId("101058")
  Scenario: Test field 'Last name'

    Given user should be on "Contact" tab
    And user fills email field with "qa@moovweb.com"

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