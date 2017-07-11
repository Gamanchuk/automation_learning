@saatva

Feature: SHIPPING PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    And presses the "Continue" button
    Then user should be on "Shipping" tab

  @TestCaseId("101242")
  Scenario: Breadcrumb links redirect user to correct page

    Given user presses "Payment & Review" breadcrumb tab
    Then user should stay at "Shipping" tab

    And user presses "Contact" breadcrumb tab
    Then user should be on "Contact" tab