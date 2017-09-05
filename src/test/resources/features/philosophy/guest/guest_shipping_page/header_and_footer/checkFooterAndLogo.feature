@philosophy

Feature: GET SHIPPING PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest

  @TestCaseId("17107")
  @TestCaseId("17109")
  @TestCaseId("17111")
  Scenario: Check footer and logo

    Given user checks support number with label "call toll-free 1-800-568-3151" and number "18005683151"
    And user checks text "©2017 philosophy, inc. all rights reserved" in footer
    And user presses the logo
    Then user should be on Philosophy main page