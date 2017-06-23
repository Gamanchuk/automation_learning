@qvc

Feature: GUEST - SHIPPING DETAILS PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102357")
  Scenario: Check Cart Icon

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types billing info for "qa user"
    And presses the "Continue" button
    And user should be on "Delivery" tab

    And user presses the Shopping Cart icon
    Then user should be on QVC cart page