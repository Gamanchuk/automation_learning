@qvc

Feature: SIGN IN PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102435")
  Scenario: Registered user is redirected to order summary page when on checking "Using your default shipping and payment information? .........Order Summary" check box.
    Given user fills email field with "yelena.poghosyan@moovweb.com"
    And presses the "Continue" button
    And user checks "Using your default shipping and payment information? Check the box to go directly to Order Summary." checkbox
    And user fills password field with "Spear160!"
    And presses the "Continue" button
    Then user should be on "Review" tab