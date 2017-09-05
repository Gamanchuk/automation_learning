@philosophy @Ignored

Feature: GUEST - SHIPPING PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest

  @TestCaseId("17260")
  Scenario: Check Address verification
    Given user types manually shipping info for "qa user"

    And user types "10 flp" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Edit Address"
    Then user should stay at "Shipping" tab

    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment" tab
    And user navigates to "Shipping" breadcrumb

    And user types "10 flo" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    Then user should be on "Payment" tab


