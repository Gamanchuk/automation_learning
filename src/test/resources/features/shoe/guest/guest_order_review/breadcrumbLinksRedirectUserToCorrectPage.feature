@shoe

Feature: GUEST - ORDER REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "mastercard" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab


  @TestCaseId("16359")
  Scenario: Breadcrumb links redirect user to correct page

    Given user presses "Payment" breadcrumb tab
    Then user should be on "Payment" tab

    And user fills "CVV" field from "mastercard" card
    And presses the "Continue" button
    Then user should be on "Review" tab

    And user presses "Shipping" breadcrumb tab
    Then user should be on "Shipping" tab