@shoe

Feature: GUEST - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    Then user should be on "Payment" tab


  @TestCaseId("16324")
  Scenario: Test with correct Mastercard billing information

    Given uses "mastercard" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab