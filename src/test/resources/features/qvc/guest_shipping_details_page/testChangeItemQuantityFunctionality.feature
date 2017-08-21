@qvc

Feature: GUEST - SHIPPING DETAILS PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102352")
  Scenario: Test Change item Quantity Functionality

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types manually billing info for "qa user" without email
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And chooses "3" item quantity
    And presses the "Continue" button

    Then user should be on "Payment" tab

