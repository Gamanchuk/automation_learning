@shoe @debug

Feature: EXPRESS PAYPAL - REVIEW PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart with PayPal checkout from Shoe
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Review" tab

  @TestCaseId("16531")
  @TestCaseId("16532")
  @TestCaseId("16533")
  @TestCaseId("16535")
  Scenario: Check footer and logo

    Given user checks support number with label "1-800-430-SHOE (7463)" and number "1-800-430-7463"
    And user checks text "Copyright © 2017 - Shoe Carnival Inc. All rights reserved." in footer
    And user presses the logo
    Then user should be on Shoe main page