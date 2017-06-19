@qvc @Ignored

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("")
  Scenario: 'start_session' event validation

    Given failed step

    Given user continue checkout as guest
    And "start_session" event should arrive to Analytics
#    And presses the "Continue" button
#    And user should be on "Address" tab
#
#    And user types billing info for "qa user"
#    And presses the "Continue" button
#
#    And chooses "UPS Ground: $4.47" shipping method
#    And presses the "Continue" button
#
#    And uses "visa" card for payment
#    And presses the "Continue" button
#
#    And user should be on "Review" tab
#    And presses the "Place Order" button
#
#    Then user should be on thank you page
    #TODO: finish this case after meeting; Now we have problem with credit cards