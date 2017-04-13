@pepBoys @debug1

Feature: GUEST - REVIEW & PLACE ORDER PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("")
  Scenario: Edit installation time
    Given user makes authorisation for "qa user"
    And user clicks arrow for "Pick Up in Store"
    And user should be on cart page
    And user changes store
    And chooses "Pay in Store" method

#    Then user types billing info for "qa user"
    And checks Pick Up in Store info




