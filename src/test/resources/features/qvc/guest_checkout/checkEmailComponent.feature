@qvc

Feature: GUEST CHECKOUT

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102436")
  Scenario: 'Sign In' to existing account only default 'Email Address' section is appearing
    Given user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab
