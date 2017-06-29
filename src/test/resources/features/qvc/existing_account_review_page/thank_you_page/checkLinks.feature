@qvc

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
    And uses saved "visa" card for payment
    And presses the "Continue" button
    And user should be on "Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page

  @TestCaseId("102009")
  Scenario: Links at Thank you page

    #TODO: Finish this case when credit cards or qCards work again
    Given user presses the "Check the status of your order now" link
    Then user should be on Order Status page