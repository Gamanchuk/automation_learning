@shoe

Feature: EXISTING ACCOUNT - SHIPPING PAGE - PICK UP IN STORE

  Background: Add product to card and process to checkout
    Given user adds product to cart with Pick up in store from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab


  @TestCaseId("16772")
  Scenario: Place order that must be Pick up in store as guest

    Given user navigates to "Pick up in Store" tab

    And user fills find store field with "10020"
    And presses the "Search" button
    Then user should be see Store results
    And user selects random store
    And user types "Moovweb QA" into the "Full Name" field of "Contact Details" address form
    And presses the "Continue" button
    Then user should be on "Payment" tab
