@shoe @debug

Feature: GUEST - SHIPPING PAGE - BILLING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    And user should be on "Payment" tab
    Then uses "mastercard" card for payment

  @TestCaseId("16345")
  Scenario: Test with correct billing information and do not fill in all required fields (error message should be displayed)

    Given unset checkbox "Yes, billing address and shipping address are the same"
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."



