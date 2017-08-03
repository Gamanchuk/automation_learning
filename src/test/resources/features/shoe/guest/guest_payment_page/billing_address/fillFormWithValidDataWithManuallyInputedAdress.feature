@shoe

Feature: GUEST - SHIPPING PAGE - BILLING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    And user should be on "Payment" tab
    Then uses "mastercard" card for payment

  @TestCaseId("16416")
  Scenario: Test with correct billing information and fill in all required fields (Address inputted manually)

    Given unset checkbox "Yes, billing address and shipping address are the same"
    And user types manually billing info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Payment" tab



