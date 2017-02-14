@pepBoys, @debug

Feature: Some feature

  @TestCaseId("15851")
  Scenario: Place Order as a "Guest" with Credit Card
    Given user is on main page
    When user selects "Cowles Products Style Guard Door Guard"
    And user adds it to the cart with "Ship to Home" delivery option
    And user views cart
#    And navigates to checkout as a Guest
#    And enters all required fields
#    And place an Order
#    Then user should be on thank you page
