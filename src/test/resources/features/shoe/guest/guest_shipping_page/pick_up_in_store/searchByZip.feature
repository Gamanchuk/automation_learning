@shoe

Feature: GUEST - SHIPPING PAGE - PICK UP IN STORE

  Background: Add product to card and process to checkout
    Given user adds product to cart with Pick up in store from Shoe

  @TestCaseId("16295")
  @TestCaseId("16296")
  Scenario: Search by zip
    Given user navigates to "Pick up in Store" tab
    And user fills find store field with "10020"
    And presses the "Search" button
    Then user should be see Store results

