#TODO: Ignore this case. This case need run only on "mstag.stage.pepboys.com".

#@pepBoys
#
#Feature: GUEST - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE
#
#  Background:
#    Given user makes appoint
#    And user adds to cart any tires with "Installation" delivery option for "captiva"
#    And user views cart
#    And user schedules installation time
#    And chooses "Pay Online" method with appointment details
#
#  @Issue("MCCAT-5505")
#  @TestCaseId("15420")
#  Scenario: Installation of detail for car
#    Given user types billing info for "qa user"
#    And presses the "Continue" button
#
#    And chooses "Ground: 5-7 Days" shipping method
#    And presses the "Continue" button
#
#    And uses "visa" card for payment
#    And presses the "Place Order" button
#
#    Then user should be on thank you page
#    And user presses the reschedule link
