@shoe

Feature: GUEST - SHIPPING PAGE - SHIPPING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe


  @TestCaseId("16282")
  Scenario: Test with correct shipping information and do not fill in all required fields (error message should be displayed)
    Given user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."



