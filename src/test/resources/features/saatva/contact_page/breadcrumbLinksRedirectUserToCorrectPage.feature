@saatva

Feature: CONTACT PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product from Saatva

  @TestCaseId("101241")
  Scenario: Breadcrumb links redirect user to correct page

    Given user should be on "Contact" tab

    And user presses "Shipping" breadcrumb tab
    Then user should stay at "Contact" tab

    And user presses "Payment & Review" breadcrumb tab
    Then user should stay at "Contact" tab