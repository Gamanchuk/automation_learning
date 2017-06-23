@qvc

Feature: EXISTING ACCOUNT - SHIPPING DETAILS PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    Then user should be on "Delivery" tab


  @TestCaseId("")
  Scenario: Check Cart Icon
    Given user presses the Shopping Cart icon
    Then user should be on QVC cart page