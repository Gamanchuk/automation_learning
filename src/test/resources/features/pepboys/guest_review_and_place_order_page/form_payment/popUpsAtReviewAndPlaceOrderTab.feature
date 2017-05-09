@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15411")
  @TestCaseId("15414")
  Scenario: Test field "Card Number"
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"

    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button

    And user should be on "Payment & Review" tab
    And user can expand and collapse Order summary

    And user clicks Terms link
    Then user should see Terms modal with "APPLICABLE LAW AND ARBITRATION AGREEMENT"

    # We can make this test faster. Need to change attribute at line 7 from "Ship To Home" to "Pick Up In Store"
    # With this option we can remove lines: 18, 19
    # Need to change title of Scenario to "Pop-ups at Review page"