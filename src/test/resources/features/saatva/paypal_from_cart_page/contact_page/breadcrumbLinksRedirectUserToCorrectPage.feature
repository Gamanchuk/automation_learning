@saatva

Feature: EXPRESS PAYPAL CHECKOUT - CONTACT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal
    #And user confirms purchase with PayPal
    And user should be on "Shipping" tab

  @TestCaseId("101939")
  Scenario: Breadcrumb links redirect user to correct page
    Given user should be on "Shipping" tab
    And user presses "Contact" breadcrumb tab
    And user should be on "Contact" tab

    And user presses "Shipping" breadcrumb tab
    Then user should stay at "Contact" tab

    And user presses "Payment & Review" breadcrumb tab
    Then user should stay at "Contact" tab