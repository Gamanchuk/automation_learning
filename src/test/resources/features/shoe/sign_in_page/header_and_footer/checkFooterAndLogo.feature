@shoe

Feature: SIGN IN PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe

  @TestCaseId("16423")
  @TestCaseId("16425")
  @TestCaseId("16426")
  Scenario: Check footer and logo
    Given user presses the signIn button
    And user checks support number with label "1-800-430-SHOE (7463)" and number "1-800-430-7463"
    And user checks text "Copyright © 2017 - Shoe Carnival Inc. All rights reserved." in footer
    And user presses the logo
    Then user should be on Shoe main page