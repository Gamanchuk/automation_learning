@qvc

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102332")
  Scenario: Test with correct billing information and do not fill in all required fields

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types billing info for "qa user" without email
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And presses the "Continue" button

    And user should be on "Payment" tab
    And presses the "Continue" button

    Then user should stay at "Payment" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

