@shoe

Feature: EXISTING ACCOUNT - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And user types shipping info for "qa user" without email
    And unset checkbox "Save this address to my address book"
    And presses the "Continue" button
    Then user should be on "Payment" tab


  @TestCaseId("16791")
  Scenario: Breadcrumb links redirect user to correct page

    Given user presses "Review" breadcrumb tab
    Then user should stay at "Payment" tab

    And user presses "Shipping" breadcrumb tab
    Then user should be on "Shipping" tab