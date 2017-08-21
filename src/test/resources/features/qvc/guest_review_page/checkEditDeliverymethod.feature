@qvc 

Feature: GUEST - REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("")
  Scenario: Check Edit Delivery method

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types manually billing info for "qa user" without email
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And presses the "Continue" button

    And user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    Then user should see "Billing Address" form
    And user clicks arrow for "Delivery Method"
    Then user should be on "Delivery" tab