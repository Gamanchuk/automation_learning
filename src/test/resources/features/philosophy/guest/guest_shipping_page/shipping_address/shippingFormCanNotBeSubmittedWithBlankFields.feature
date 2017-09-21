@philosophy

Feature: GUEST - SHIPPING PAGE - SHIPPING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest

  @TestCaseId("17229")
  @TestCaseId("17241")
  Scenario: Test with correct shipping information and do not fill in all required fields (error message should be displayed)
    Given user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."



