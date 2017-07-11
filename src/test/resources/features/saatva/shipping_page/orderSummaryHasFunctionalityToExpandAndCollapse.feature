@saatva @debug

Feature: CONTACT PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product from Saatva
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button


  @TestCaseId("100994")
  Scenario: Order summary has functionality to expand and collapse
    Given user should be on "Shipping" tab
    Then user can expand and collapse Order summary