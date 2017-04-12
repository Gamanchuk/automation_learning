@pepBoys @debug

Feature: Guest - Shipping & Billing page (Pay In Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "627494" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16651")
  Scenario Outline: Test field 'Email' Negative
    Given user types billing info for "qa user"
    And user types "<value>" into the email field
    And presses the "Place Order" button
    And sees "FORM ERRORS" error message with text "<error>"
    And clean up cart

    Examples:
      | value               | error                     |
      |                     | Please review all inputs. |
      | #######@moovweb.com | Email Address is invalid  |
      | qamoovweb.com       | Please review all inputs. |
      | qa@moovweb          | Please review all inputs. |