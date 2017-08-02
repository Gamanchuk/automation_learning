@shoe @debug

Feature: GUEST - ORDER REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user types shipping info for "qa user"
    And user types billing info for "qa user"
    And presses the "Continue" button
    And user should be on "Payment" tab
    And uses "mastercard" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab

  @TestCaseId("16368")
  Scenario: Change billing address

    Given user clicks arrow for "Billing Address"
    And user should be on "Payment" tab
    And user types manually billing info for "qa user2"
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Review" tab




