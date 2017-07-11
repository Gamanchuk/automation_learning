@saatva

Feature: SHIPPING PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

  @TestCaseId("100994")
  Scenario: Order summary has functionality to expand and collapse
    Given user should be on "Shipping" tab
    Then user can expand and collapse Order summary