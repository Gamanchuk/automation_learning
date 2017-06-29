@qvc

Feature: GUEST CHECKOUT

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102438")
  Scenario: 'Where do I enter my password?' link open the suggestion content.
    Given user continue checkout as guest
    Then user presses the Where do I enter my password link


