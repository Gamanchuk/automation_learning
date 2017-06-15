@qvc


Feature: GUEST - BREADCRUMB

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102317")
  Scenario: Breadcrumb links redirect user to correct page
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email

    # Check from Delivery tab
    Then user presses "Delivery" breadcrumb tab
    And user presses "Payment" breadcrumb tab
    And user presses "Review" breadcrumb tab
    And presses the "Continue" button
    And user should be on "Delivery" tab

    # Check from Payment tab
    Then user presses "Payment" breadcrumb tab
    And user presses "Review" breadcrumb tab
    And user navigates to "Address" breadcrumb
    And presses the "Continue" button
    And user should be on "Delivery" tab
    And presses the "Continue" button
    And user should be on "Payment" tab
    Then user navigates to "Delivery" breadcrumb
    And presses the "Continue" button
    And user should be on "Payment" tab
    Then user navigates to "Address" breadcrumb
    And user navigates to "Payment" breadcrumb

    And uses "mastercard" card for payment
    And presses the "Continue" button


    # Check from Review tab
    Then user navigates to "Payment" breadcrumb
    And user navigates to "Review" breadcrumb

    Then user navigates to "Delivery" breadcrumb
    And user navigates to "Review" breadcrumb

    Then user navigates to "Address" breadcrumb
    And user navigates to "Review" breadcrumb



#TODO:Have a bug. Need debug after fix problem





