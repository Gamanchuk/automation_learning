#TODO: Ignore this case. This case need run only on "mstag.stage.pepboys.com".

#@pepBoys @ignored
#
#Feature: HAPPY PATH
#
#  Background:
#    Given user makes appoint
#    And user adds to cart product with "Pick Up in Store" delivery option
#    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
#    And user adds to cart any tires with "Installation" delivery option for "captiva"
#    And user views cart
#    And user schedules installation time
#    And chooses "Pay Online" method with appointment details
#
#  @Issue("MCCAT-5505")
#  @TestCaseId("16253")
#  Scenario: Place Multiple Orders as exist user
#    Given user makes authorisation for "qa user"
#    And applies billing info for address "201 SPEAR ST"
#    And presses the "Continue" button
#    And chooses "Use Recommended Address"
#    And chooses "Ground: 5-7 Days" shipping method
#    And presses the "Continue" button
#    And uses "visa" card for payment
#    And presses the "Place Order" button
#    Then user should be on thank you page
