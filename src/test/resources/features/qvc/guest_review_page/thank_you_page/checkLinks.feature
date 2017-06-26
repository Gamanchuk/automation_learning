@qvc

Feature: GUEST - REVIEW & PLACE ORDER PAGE - THANK YOU PAGE

  Background: test thank you page as guest user
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    And user types billing info for "qa user"
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "visa" card for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    And presses the "Place Order" button

  @TestCaseId("102037")
  Scenario: Links at Thank you page
    Given user should be on thank you page

    #TODO: Finish this case when credit cards or qCards work again
    Then user presses the Check the status of your order link
    Then user should be on "Order Status" page

