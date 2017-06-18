@qvc

Feature: GUEST - SHIPPING & BILLING ADDRESS PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

  @TestCaseId("102357")
  Scenario: Check Cart Icon

    When user presses the Shopping Cart icon
    Then user should be on QVC cart page

