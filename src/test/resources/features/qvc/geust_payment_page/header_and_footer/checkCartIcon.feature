@qvc

Feature: GUEST - REVIEW PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102349")
  Scenario: Check Cart Icon

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types billing info for "qa user" without email
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And presses the "Continue" button

    Then user should be on "Payment" tab
    And user presses the Shopping Cart icon
    And user should be on QVC cart page

