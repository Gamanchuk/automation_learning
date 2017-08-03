@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And user types shipping info for "qa user" without email
    And unset checkbox "Save this address to my address book"
    And presses the "Continue" button
    Then user should be on "Payment" tab


  @TestCaseId("16792")
  @TestCaseId("16793")
  @TestCaseId("16795")
  Scenario: Check footer and logo

    And user checks support number with label "1-800-430-SHOE (7463)" and number "1-800-430-7463"
    And user checks text "Copyright © 2017 - Shoe Carnival Inc. All rights reserved." in footer
    And user presses the logo
    Then user should be on Shoe main page