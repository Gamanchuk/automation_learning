@pepBoys @debug1

Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "9046614" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method


  @TestCaseId("16646")
  Scenario Outline: Test field 'Apartment'
    Given user types billing info for "qa user"
    And user types "<value>" into the "Apt, Bldg." field of "Billing Address" form
    And presses the "Place Order" button
    Then user should be on thank you page
    And user checks "Apt, Bldg." with value "<value>" on thank you page
    And clean up cart
    Examples:
      | value          |
      |                |
      | 12345          |
      | Some Apartment |
      | !#&@()         |