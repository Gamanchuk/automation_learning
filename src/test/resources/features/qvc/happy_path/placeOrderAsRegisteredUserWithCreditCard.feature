@qvc @debug

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102220")
  Scenario: Place Order as a "Registered User" with Credit Card

    Given user continue checkout as "qa user"
    And presses the "Continue" button

    And user should be on "Address" tab
    And presses the "Continue" button

    And chooses "UPS Ground: $4.47" shipping method
    And presses the "Continue" button

    And uses "visa" card for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    And presses the "Place Order" button

    Then user should be on thank you page