@qvc @debug

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @Issue("MCCAT-6010")
  @TestCaseId("102225")
  Scenario: Place Order with Q-CARD

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types billing info for "qa user"
    And presses the "Continue" button
    
    And user should be on "Delivery" tab
    And presses the "Continue" button

    And uses "qcard" card for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    And presses the "Place Order" button

    Then user should be on thank you page
