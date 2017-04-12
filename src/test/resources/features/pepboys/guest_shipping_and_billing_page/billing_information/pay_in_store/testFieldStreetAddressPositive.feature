@pepBoys @debug


Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "9046571" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16645")
  Scenario Outline: Test field 'Address Street' Positive
    Given user types billing info for "qa user"
    And user types "<value>" into the "Street Address" field of "Billing Address" form
    And presses the "Place Order" button
    Then user should be on thank you page
    And user checks "Email" with value "<value>" on thank you page
    And clean up cart

    Examples:
      | value          |
      | Mission Street |
      | 123456         |
      | !@$%^&*():_+   |
