@pepBoys, @debug

Feature: Some feature

#  Background:
#    Given user makes appoint with zip-code "94105"
#    And user add to cart product with id "8536851" with "Ship to Home" delivery option
#    And user views cart
#    And chooses "Pay Online" method

  @TestCaseId("59329")
  Scenario: Place Order as a "Guest" with Credit Card
    # TODO: move it to the background
    Given user makes appoint with zip-code "94105"
    And user add to cart product with id "8536851" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

    Given user types billing info for "qa user"
    And chooses "Ground" shipping method
    And uses "visa" card for payment
    Then user should be on thank you page

