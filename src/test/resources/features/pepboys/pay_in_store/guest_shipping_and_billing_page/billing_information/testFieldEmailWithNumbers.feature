@pepBoys

Feature: PAY IN STORE - GUEST - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16651")
  Scenario: Test field 'Email' with numbers
    Given user types customer info for "qa user"
    And user types "123456@moovweb.com" into the email field
    And presses the "Place Order" button
    Then user checks "Email" with value "123456@moovweb.com" on thank you page



