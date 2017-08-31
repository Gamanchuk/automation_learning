@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab
    And user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And user types "123 mission st ste 1020" into the "Street Address" field of "Shipping Address" address form

  @TestCaseId("101203")
  @TestCaseId("101205")
  @TestCaseId("101206")
  Scenario: Check footer and Logo Icon

    When user checks support number with label "1-877-672-2882" and number "18776722882"
    And user checks text "Copyright © 2010-2017 Saatva, Inc." in footer
    And user presses the logo
    Then user should be on Saatva main page