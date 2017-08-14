@shoe

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds product to cart with Pick up in store from Shoe


  @TestCaseId("16272")
  Scenario: Place order that must be Pick up in store as existing user

    Given user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And user navigates to "Pick up in Store" tab

    And user fills find store field with "10020"
    And presses the "Search" button
    Then user should be see Store results
    And user selects random store
    And user types "Moovweb QA" into the "Full Name" field of "Contact Details" address form

    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page
