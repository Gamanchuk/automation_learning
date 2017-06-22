@qvc

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @Issue("MCCAT-6011")
  @TestCaseId("102221")
  @TestCaseId("102278")
  Scenario: Place Order with Paypal Credit from Payment page

    Given user continue checkout as "qa paypal"
    And presses the "Continue" button

    And user should be on "Address" tab
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And presses the "Continue" button

    And uses "(formerly Bill Me Later®)" for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    And presses the "Place Order" button

    Then user should be on thank you page