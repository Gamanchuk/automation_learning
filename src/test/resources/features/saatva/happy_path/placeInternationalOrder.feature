@saatva

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa canada"
    Then presses the "Continue" button

  @TestCaseId("100977")
  Scenario: Canadian Shipping address
    Given chooses "Canada" country
    And user types shipping address for "qa canada" with phone number

    And presses the "Continue" button
    And user should be on "Payment & Review" tab

    And uses "mastercard" card for payment
    And presses the "Place Order" button
    Then user should be on thank you page
