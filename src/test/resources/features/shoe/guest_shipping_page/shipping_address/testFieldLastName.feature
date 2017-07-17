@shoe

Feature: GUEST - SHIPPING PAGE - SHIPPING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe

  @TestCaseId("16284")
  Scenario: Test field 'Last name'

    Given user types shipping info for "qa user"

    And user types "Moovweb" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Moovweb !@#&::!@#()" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Payment" tab



