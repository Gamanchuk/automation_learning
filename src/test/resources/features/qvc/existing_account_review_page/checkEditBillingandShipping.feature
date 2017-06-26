@qvc

Feature: EXISTING - REVIEW PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102274")
  Scenario: Check Edit Billing and Shipping info

    Given user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And presses the "Continue" button

    And user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    Then user should see "Billing Address" form
    And user clicks arrow for "Billing Address"
    Then user should be on "Address" tab