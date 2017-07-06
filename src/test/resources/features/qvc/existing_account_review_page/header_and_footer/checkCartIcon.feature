@qvc

Feature: EXISTING ACCOUNT - REVIEW PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And user selects "1 payment" Payment Option
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    Then user should see "Billing Address" form

  @TestCaseId("102380")
  Scenario: Check Cart Icon
    Given user presses the Shopping Cart icon
    Then user should be on QVC cart page