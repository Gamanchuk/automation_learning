@shoe

Feature: EXISTING ACCOUNT - SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab

  @TestCaseId("16746")
  Scenario: Test with correct billing information and fill in all required fields (Address inputted manually)

    Given user types manually shipping info for "qa user" without email
    And unset checkbox "Save this address to my address book"
    And presses the "Continue" button
    Then user should be on "Payment" tab



