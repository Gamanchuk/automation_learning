@pepBoys 

Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "627487" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16647")
  Scenario Outline: Test field 'City'
    Given user types billing info for "qa user"
    And user types "<value>" into the "City" field of "Billing Address" address form
    And presses the "Place Order" button
    Then user should be on thank you page
    And user checks city info with value "<value>" on thank you page
    And clean up cart

    Examples:
      | value        |
      | SanFrancisco |
      | 123456       |
      | !@$%^&*():_+ |