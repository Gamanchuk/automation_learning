@saatva

Feature: EXPRESS PAYPAL CHECKOUT - CONTACT PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal
    #And user confirms purchase with PayPal
    And user should be on "Shipping" tab
    And user presses "Contact" breadcrumb tab
    And user should be on "Contact" tab

  @TestCaseId("101942")
  @TestCaseId("101944")
  @TestCaseId("101945")
  Scenario: Check footer and Logo Icon

    When user checks support number with label "1-877-672-2882" and number "18776722882"
    And user checks text "Copyright © 2010-2017 Saatva, Inc." in footer
    And user presses the logo
    Then user should be on Saatva main page