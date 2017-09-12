@philosophy

Feature: GUEST - PAYMENT & BILLING ADDRESS PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest
    Then user should be on "Shipping" tab
    And user types shipping info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab

  @TestCaseId("17134")
  @TestCaseId("17136")
  @TestCaseId("17138")
  Scenario: Check footer and logo

    And user checks support number with label "call toll-free 1-800-568-3151" and number "18005683151"
    And user checks text "©2017 philosophy, inc. all rights reserved" in footer
    And user presses the logo
    Then user should be on Philosophy main page