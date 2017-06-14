@qvc

Feature: SIGN IN PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102435")
  Scenario: Registered user is redirected to order summary page when on checking "Using your default shipping and payment information? .........Order Summary" check box.
    Given user continue checkout as "qa user2"
    And user checks "Using your default shipping and payment information?" checkbox
    And presses the "Continue" button
    Then user should be on "Address" tab