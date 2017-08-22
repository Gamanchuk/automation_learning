@qvc

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102219")
  Scenario: Place Order as a "Guest" with Credit Card

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types manually billing info for "qa user" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"

    And user should be on "Delivery" tab
    And presses the "Continue" button

    And uses "mastercard" card for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    And presses the "Place Order" button

    Then user should be on thank you page
