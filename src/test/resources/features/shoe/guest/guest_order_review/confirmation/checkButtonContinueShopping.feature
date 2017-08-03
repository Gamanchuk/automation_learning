@shoe

Feature: GUEST - ORDER REVIEW PAGE - THANK YOU PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "mastercard" card for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page

  @TestCaseId("16372")
  @TestCaseId("16374")
  @TestCaseId("16375")
  Scenario: Check button Continue Shopping

    Given presses the "Continue Shopping" button
    Then user should be on Shoe main page
