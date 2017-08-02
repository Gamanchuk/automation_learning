@shoe

Feature: PAYMENT & REVIEW - REVIEW INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "mastercard" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab

  @TestCaseId("16368")

  Scenario: Change shipping address

    Given user clicks arrow for "Shipping Address"
    And user should be on "Shipping" tab
    And user types manually shipping info for "qa user2"
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment" tab




