@pepBoys

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15451")
  Scenario: Tap on icon Shopping Cart navigate to shopping cart page (Existent user, Pay Online, Payment & Review tab)
    Given user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment
    And user presses the Shopping Cart icon
    Then user should be on cart page

    # Change title of Scenario to "Check Shopping cart icon redirection"
    # Need to change attribute at line 7 from "ship to home" to "Pick up in store"
    # And remove lines: 18,19. Also we can remove 20 line because it isn't necessary to enter info about CC

