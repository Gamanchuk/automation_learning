@qvc @debug

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE

  Background: Add product to card and process to checkout
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

  @TestCaseId("102009")
  Scenario: Links at Thank you page
    Given user should be on thank you page

    #TODO: Finish this case when credit cards or qCards work again
    Then user presses the Check the status of your order link
    Then user should be on "Order Status" page