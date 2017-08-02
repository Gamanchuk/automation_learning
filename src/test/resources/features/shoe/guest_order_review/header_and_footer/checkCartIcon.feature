@shoe

Feature: GUEST - ORDER REVIEW PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    Then user should be on "Payment" tab

  @TestCaseId("16395")
  Scenario: Check Cart icon

    Given user presses the Shopping Cart icon
    Then user should be on Shoe cart page