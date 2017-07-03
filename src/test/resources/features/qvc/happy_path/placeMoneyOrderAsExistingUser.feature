@qvc

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102224")
  @TestCaseId("102279")
  Scenario: Place Money Order as Existing User


    Given user continue checkout as "qa user"
    And presses the "Continue" button

    And user should be on "Address" tab
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And presses the "Continue" button

    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    And presses the "Place Order" button

    Then user should be on thank you page
