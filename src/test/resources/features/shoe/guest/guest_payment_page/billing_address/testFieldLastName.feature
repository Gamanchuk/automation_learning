@shoe

Feature: GUEST - SHIPPING PAGE - BILLING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    And user should be on "Payment" tab
    Then uses "mastercard" card for payment

  @TestCaseId("16347")
  Scenario: Test field 'Last name'

    Given unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user" without email

    And user types "Moovweb" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Moovweb !@#&::!@#()" into the "Full Name" field of "Billing Address" address form
    And presses the "Continue" button
    Then user should be on "Review" tab



