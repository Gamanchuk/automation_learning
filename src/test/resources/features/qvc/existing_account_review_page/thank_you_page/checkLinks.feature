@qvc
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
    And presses the "Place Order" button

  @TestCaseId("102009")
  Scenario: Links at Thank you page
    Given user should be on thank you page

    #TODO: Finish this case when credit cards or qCards work again
    Then user presses the Find out more link
    And user should be on rewards page
