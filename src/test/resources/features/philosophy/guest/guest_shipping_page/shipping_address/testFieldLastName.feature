@philosophy

Feature: GUEST - SHIPPING PAGE - SHIPPING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest

  @TestCaseId("17231")
  Scenario: Test field 'Last name'

    Given user types shipping info for "qa user" without email

    And user types "Moovweb" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "Moovweb !@#&::!@#()" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab



