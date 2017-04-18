@pepBoys

Feature: GUEST - THANK YOU PAGE

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16663")
  Scenario: Links at Thank you page (Guest, Pay in Store)
    Given user types billing info for "qa user"
    And presses the "Place Order" button
    And user should be on thank you page
    Then user presses the Find out more link
    And user should be on rewards page

