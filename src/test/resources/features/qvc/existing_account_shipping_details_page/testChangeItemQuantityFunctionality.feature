@qvc

Feature: EXISTING ACCOUNT - SHIPPING DETAILS PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    Then user should be on "Delivery" tab


  @TestCaseId("102304")
  Scenario: Test Change item Quantity Functionality

    Given chooses "3" item quantity
    And presses the "Continue" button
    Then user should be on "Payment" tab
