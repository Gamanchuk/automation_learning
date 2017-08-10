@shoe

Feature: EXISTING ACCOUNT - ORDER REVIEW PAGE - THANK YOU PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page

  @TestCaseId("16841")
  @TestCaseId("16840")
  @TestCaseId("16838")
  Scenario: Check button Continue Shopping

    Given presses the "Continue Shopping" button
    Then user should be on Shoe main page
