@pepBoys 

Feature: EXISTING ACCOUNT - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @Issue("MCCAT-5562")
  @TestCaseId("15468")
  Scenario: Change store
    Given user makes authorisation for "qa user"
    And user clicks arrow for "Pick Up in Store"
    And user should be on cart page

    And user changes store
    And chooses "Pay in Store" method

    Then user should be on "Payment & Review" page
    And checks Pick Up in Store info




