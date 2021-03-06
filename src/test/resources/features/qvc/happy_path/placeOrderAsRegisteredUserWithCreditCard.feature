@qvc

Feature: HAPPY PATH

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @Issue("MCCAT-6001")
  @TestCaseId("102220")
  Scenario: Place Order as a "Registered User" with Credit Card

    Given user continue checkout as "qa user"
    And presses the "Continue" button

    And user should be on "Address" tab
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And presses the "Continue" button

    And user should be on "Payment" tab
    And user selects "1 payment" Payment Option
    And uses saved "visa-saved" card for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    And presses the "Place Order" button

    Then user should be on thank you page

