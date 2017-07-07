@qvc

Feature: GUEST - SHIPPING RESTRICTIONS


  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    Then presses the "Continue" button

  @TestCaseId("101815")
  Scenario: Check Canada validation message

    Given user should be on "Address" tab
    Then chooses "Canada" country
