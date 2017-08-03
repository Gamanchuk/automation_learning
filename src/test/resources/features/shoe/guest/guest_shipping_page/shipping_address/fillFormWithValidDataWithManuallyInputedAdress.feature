@shoe

Feature: GUEST - SHIPPING PAGE - SHIPPING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe

  @TestCaseId("16401")
  Scenario: Test with correct billing information and fill in all required fields (Address inputted manually)

    Given user types manually shipping info for "qa user"
    And presses the "Continue" button
    Then user should be on "Payment" tab



