@qvc @debug

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE

  Background: test thank you page as existing user
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then presses the "Place Order" button

  @TestCaseId("102010")
  Scenario: Check button Continue Shopping

    Given user should be on thank you page
    Then presses the "Continue Shopping" button
    And user should be on QVC main page
