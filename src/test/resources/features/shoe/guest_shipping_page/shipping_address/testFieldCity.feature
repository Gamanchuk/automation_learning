@shoe

Feature: GUEST - SHIPPING PAGE - SHIPPING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe


  @TestCaseId("16287")
  Scenario: Test field 'City'
    Given user types shipping info for "qa user"

    And user types "" into the "City" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "SanFrancisco" into the "City" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment" tab
    And user navigates to "Shipping" breadcrumb

    And user types "123456" into the "City" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment" tab
    And user navigates to "Shipping" breadcrumb

    And user types "!@$%^&*():_+" into the "City" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment" tab

