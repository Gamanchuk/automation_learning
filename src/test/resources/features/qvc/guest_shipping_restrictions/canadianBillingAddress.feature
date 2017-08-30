@qvc

Feature: GUEST - SHIPPING RESTRICTIONS


  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    Then presses the "Continue" button

  @TestCaseId("101816")
  Scenario: Canadian billing address

    Given user should be on "Address" tab
    And chooses "Canada" country
    And user types manually Canadian billing address for "qa canada" without email
    And user types manually shipping address for "qa user" without same as billing checkbox
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab
