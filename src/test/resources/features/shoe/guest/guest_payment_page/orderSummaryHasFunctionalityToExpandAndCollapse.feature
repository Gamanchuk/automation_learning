@shoe

Feature: GUEST - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button

  @TestCaseId("16338")
  Scenario: Order summary has functionality to expand and collapse
    Given user should be on "Payment" tab
    Then user can expand and collapse Order summary