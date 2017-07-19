@saatva

Feature: HAPPY PATH - MULTIPLE ITEMS

  Background: Add product to card and process to checkout
    Given user adds to cart "3" products from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button


  @TestCaseId("100975")
  Scenario: Place multiple Orders
    Given user types shipping address for "qa user" with phone number
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab

    And uses "mastercard" card for payment
    And presses the "Place Order" button

