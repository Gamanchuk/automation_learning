@saatva

Feature: PAYMENT & REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    And presses the "Continue" button
    And user should be on "Shipping" tab
    And user types shipping address for "qa user" with phone number
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab

  @TestCaseId("101243")
  Scenario: Breadcrumb links redirect user to correct page

    Given user presses "Payment & Review" breadcrumb tab
    Then user should stay at "Payment & Review" tab

    And user presses "Contact" breadcrumb tab
    Then user should be on "Contact" tab

    And presses the "Continue" button
    And user should be on "Payment & Review" tab

    And user presses "Shipping" breadcrumb tab
    And user should be on "Shipping" tab
    
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab