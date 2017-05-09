@pepBoys

Feature: GUEST - REVIEW & PLACE ORDER PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15484")
  @TestCaseId("15486")
  @TestCaseId("15488")
  Scenario: Check footer and logo
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment
    And user checks support number with label "1-800-PEP-BOYS (737-2697)" and number "18007372697"
    And user checks text "© Copyright 2017 - The Pep Boys" in footer
    And user presses the logo
    Then user should be on main page

    # Need to change attribute at line 7 from "ship to home" to "Pick up in store"
    # And remove lines: 19, 20
    # Also we don't need to input information about CC => can remove line 21
