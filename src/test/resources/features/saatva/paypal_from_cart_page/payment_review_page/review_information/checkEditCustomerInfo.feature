@saatva

Feature: EXPRESS PAYPAL CHECKOUT - REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

  @TestCaseId("101196")

  Scenario: Check Edit Customer Information
    Given user types shipping address for "qa user" with phone number
    And presses the "Continue" button
    And chooses "Use Entered Address"

    And user should be on "Payment & Review" tab
    And user can expand and collapse Order summary

    Then user should see "Billing Address" form
    And user clicks arrow for "Customer Information"
    Then user should be on "Contact" tab
    And user can expand and collapse Order summary
