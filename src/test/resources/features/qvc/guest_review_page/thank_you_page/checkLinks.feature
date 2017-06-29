@qvc

Feature: GUEST - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And presses the "Continue" button
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page

  @TestCaseId("102037")
  Scenario: Links at Thank you page

    Given user presses the "Check the status of your order now" link
    Then user should be on Order Status page
