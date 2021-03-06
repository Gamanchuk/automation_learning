@saatva

Feature: CONTACT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page

  @TestCaseId("101060")
  Scenario: Test field 'Email' with numbers

    Given user should be on "Contact" tab
    And user types "Moovweb Qa" into the "Full Name" field
    And user fills email field with "12345@gmail.com"
    And presses the "Continue" button
    Then user should be on "Shipping" tab

