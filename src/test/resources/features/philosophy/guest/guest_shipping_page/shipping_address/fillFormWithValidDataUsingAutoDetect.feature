@philosophy

Feature: GUEST - SHIPPING PAGE - SHIPPING ADDRESS

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest
    Given user should be on "Shipping" tab
    Then user can expand and collapse Order summary

  @TestCaseId("17228")
  @TestCaseId("82936")
  Scenario: Test with correct shipping information and fill in all required fields

    Given user types shipping info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Delivery" tab


