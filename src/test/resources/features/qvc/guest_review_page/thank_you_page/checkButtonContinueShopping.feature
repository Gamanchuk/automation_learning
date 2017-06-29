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


  @TestCaseId("102038")
  Scenario: Check button Continue Shopping

    #TODO: Test this case when credit cards or qCards work again to confirm
    Given presses the "Continue Shopping" button
    Then user should be on QVC main page
