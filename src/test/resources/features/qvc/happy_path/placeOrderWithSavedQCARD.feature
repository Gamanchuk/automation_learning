@qvc @debug

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("")
  Scenario: Place Order with saved Q-CARD

    Given user continue checkout as "qa user"
    And presses the "Continue" button

    And user should be on "Address" tab
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And presses the "Continue" button

    And user should be on "Payment" tab
    And uses saved "qcard" card for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    And presses the "Place Order" button

    Then user should be on thank you page
