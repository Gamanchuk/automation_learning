@qvc


Feature: GUEST - BREADCRUMB

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab

  @TestCaseId("102039")
  Scenario: Breadcrumb links redirect user to correct page

    When user types manually billing info for "qa user" without email

    # Check from Address tab
    And user presses "Delivery" breadcrumb tab
    And user presses "Payment" breadcrumb tab
    And user presses "Review" breadcrumb tab
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Delivery" tab

    # Check return back From Delivery to Address
    And user navigates to "Address" breadcrumb
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Delivery" tab

    # Check from Delivery tab
    And user presses "Payment" breadcrumb tab
    And user presses "Review" breadcrumb tab
    And presses the "Continue" button
    Then user should be on "Payment" tab

    # Check return back From Payment to Delivery
    And user navigates to "Delivery" breadcrumb
    And presses the "Continue" button
    And user should be on "Payment" tab

    # Check from Payment tab
    And user presses "Review" breadcrumb tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    Then user should be on "Review" tab

    # Check return back From Payment to Delivery
    Then user navigates to "Payment" breadcrumb




