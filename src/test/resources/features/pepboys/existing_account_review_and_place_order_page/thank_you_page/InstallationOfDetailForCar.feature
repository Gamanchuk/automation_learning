#TODO: Ignore this case. This case need run only on "mstag.stage.pepboys.com". Add some solution for this.


#@pepBoys
#
#Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE
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
#    Given user makes authorisation for "qa user"
#    And applies billing info for address "123 Mission Street, 10th Floor"
#    And presses the "Continue" button
#
#    And user should be on "Payment & Review" tab
#    And uses "visa" card for payment
#    And presses the "Place Order" button
#    And user should be on thank you page
#    And user presses the reschedule link
