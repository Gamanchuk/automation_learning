@pepBoys @debug


Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "832661" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16644")
  Scenario Outline: Test field 'Last name'
    Given user types billing info for "qa user"
    And user types "<string>" into the "Full Name" field of "Billing Address" form
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "<error>"


    Examples:
      | string              | error                     |
      | Moovweb             | Please review all inputs. |
      | Moovweb !@#&::!@#() | Last Name is invalid      |







