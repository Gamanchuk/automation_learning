@qvc

Feature: GUEST CHECKOUT

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102437")
  Scenario: Ensure that when proceeding with register/unregistered email id, password filed will appear
    Given user continue checkout as "qa user"
    And presses the "Continue" button
    Then user should be on "Address" tab
#