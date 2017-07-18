@saatva @debug

Feature: PAYMENT & REVIEW - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    And presses the "Continue" button
    Then user should be on "Shipping" tab


  @TestCaseId("")
  Scenario: Check Cart Icon
    Given user types shipping address for "qa user" with phone number

    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab

    And user presses the Shopping Cart icon
    Then user should be on Saatva cart page