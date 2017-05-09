@pepBoys

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("15464")
  @TestCaseId("15447")
  Scenario: Pop-ups at Review and Place order page
    Given user makes authorisation for "qa user"
    And user should be on "Billing & Shipping" tab
    And presses the "Continue" button

    And user should be on "Payment & Review" tab
    And user can expand and collapse Order summary

    And user clicks Terms link
    Then user should see Terms modal with "APPLICABLE LAW AND ARBITRATION AGREEMENT"
