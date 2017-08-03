@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And user types shipping info for "qa user" without email
    And unset checkbox "Save this address to my address book"
    And presses the "Continue" button
    Then user should be on "Payment" tab


  @TestCaseId("16796")
  Scenario: Test with correct Visa billing information

    Given uses "visa" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab
