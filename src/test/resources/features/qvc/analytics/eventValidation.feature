@qvc @Ignored


Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("")
  Scenario: 'start_session' event validation

    Given failed step

    Given user continue checkout as guest
    And "start_session" event should arrive to Analytics
