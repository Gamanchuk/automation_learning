@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab

  @TestCaseId("101864")
  @TestCaseId("101866")
  @TestCaseId("101867")
  Scenario: Check footer and Logo Icon

    When user checks support number with label "1-877-672-2882" and number "18776722882"
    And user checks text "Copyright © 2010-2017 Saatva, Inc." in footer
    And user presses the logo
    Then user should be on Saatva main page