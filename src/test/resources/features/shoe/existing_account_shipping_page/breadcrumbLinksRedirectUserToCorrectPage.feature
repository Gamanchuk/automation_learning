@shoe @debug

Feature: EXISTING ACCOUNT - SHIPPING PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"

  @TestCaseId("16740")
  Scenario: Breadcrumb links redirect user to correct page

    Given user should be on "Shipping" tab

    And user presses "Payment" breadcrumb tab
    Then user should stay at "Shipping" tab

    And user presses "Review" breadcrumb tab
    Then user should stay at "Shipping" tab