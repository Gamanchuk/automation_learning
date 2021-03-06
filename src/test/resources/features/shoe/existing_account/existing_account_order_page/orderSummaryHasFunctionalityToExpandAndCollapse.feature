@shoe

Feature: EXISTING ACCOUNT - ORDER REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment
    And presses the "Continue" button


  @TestCaseId("16831")
  Scenario: Order summary has functionality to expand and collapse
    Given user should be on "Review" tab
    Then user can expand and collapse Order summary