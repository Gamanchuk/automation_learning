@qvc

Feature: GUEST CHECKOUT

  Background: Add product to card and process to checkout
    Given user adds to cart product


  Scenario: some test
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab