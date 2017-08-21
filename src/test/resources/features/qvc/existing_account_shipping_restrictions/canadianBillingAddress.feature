@qvc

Feature: EXISTING ACCOUNT - SHIPPING RESTRICTIONS


  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    Then presses the "Continue" button

  @TestCaseId("101816")
  Scenario: Canadian billing address

    Given user should be on "Address" tab
    And chooses "Canada" country
    And selects "Enter a New Address" for shipping address
    And user types Canadian billing address for "qa canada" without email
    Then user should be see country note with text "We're sorry, shipping to Canada is not available."
    And user types manually shipping address for "qa user" without same as billing checkbox
    And presses the "Continue" button
    Then user should be on "Delivery" tab


