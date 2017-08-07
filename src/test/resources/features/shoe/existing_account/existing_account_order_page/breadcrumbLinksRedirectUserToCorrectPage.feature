@shoe

Feature: EXISTING ACCOUNT - ORDER REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And uses saved "visa" card for payment
    And user fills "CVV" field from "visa" card
    And presses the "Continue" button
    Then user should be on "Review" tab


  @TestCaseId("16828")
  Scenario: Breadcrumb links redirect user to correct page

    Given user presses "Payment" breadcrumb tab
    Then user should be on "Payment" tab

    And user fills "CVV" field from "visa" card
    And presses the "Continue" button
    Then user should be on "Review" tab

    And user presses "Shipping" breadcrumb tab
    Then user should be on "Shipping" tab