@qvc

Feature: GUEST - SHIPPING RESTRICTIONS


  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    Then presses the "Continue" button

  @TestCaseId("101814")
  Scenario: Check default shipping country

    Given user should be on "Address" tab
    Then user should see "United States" shipping country
