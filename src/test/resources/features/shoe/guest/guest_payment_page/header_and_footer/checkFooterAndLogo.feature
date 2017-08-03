@shoe

Feature: GUEST - PAYMENT PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    Then user should be on "Payment" tab

  @TestCaseId("16388")
  @TestCaseId("16389")
  @TestCaseId("16391")
  @TestCaseId("16335")
  Scenario: Check footer and logo

    Given user checks support number with label "1-800-430-SHOE (7463)" and number "1-800-430-7463"
    And user checks text "Copyright © 2017 - Shoe Carnival Inc. All rights reserved." in footer
    And user presses the logo
    Then user should be on Shoe main page