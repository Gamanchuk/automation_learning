@pepBoys

Feature: GUEST - DELIVERY METHOD PAGE - HEADER & FOOTER

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15487")
  Scenario: Check Cart icon
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground: 5-7 Days" shipping method
    And user presses the Shopping Cart icon
    Then user should be on cart page

    # Line 17 can be deleted we don't need to set inforamtion about Delivery method at this case