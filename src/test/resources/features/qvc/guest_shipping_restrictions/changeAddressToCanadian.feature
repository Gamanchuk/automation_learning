@qvc @debug

Feature: GUEST - SHIPPING RESTRICTIONS


  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    Then presses the "Continue" button

  @TestCaseId("101816")
  Scenario: Canadian billing address to Canadian

    Given user should be on "Address" tab
    And chooses "Canada" country
    And user types Canadian billing address for "qa canada" without email

    Then user should be see country note with text "We're sorry, shipping to Canada is not available."
    And user types shipping address for "qa user"
    And presses the "Continue" button
    And chooses "Use Entered Address"

    Then user should be on "Delivery" tab
    And presses the "Continue" button
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button

    Then user should be on "Review" tab
    Then user should see "Billing Address" form
    And user clicks arrow for "Billing Address"
    Then user should be on "Address" tab
    And user types Canadian billing address for "qa canada" without email