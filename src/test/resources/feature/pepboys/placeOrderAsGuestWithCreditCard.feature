@pepBoys, @debug

Feature: Some feature

  @TestCaseId("15851")
  Scenario: Place Order as a "Guest" with Credit Card
    Given user is on main page
    When user selects "Cowles Products Style Guard Door Guard"
    And adds it to the cart with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method
    And types billing info for "qa user" with "Ground" shipping method and "visa" card

   # And place an Order
#    Then user should be on thank you page
