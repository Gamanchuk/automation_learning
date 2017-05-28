@pepBoys @debug

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - BILLING INFO

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @Issue("MCCAT-5848")
  @TestCaseId("91890")
  Scenario: Test with chosen billing address from saved addresses of drop-down
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab

    And applies shipping info for address "8th avenue, Unit 1611"
    And presses the "Continue" button

    And chooses "Ground: 5-7 Days" shipping method
    And user checks shipping info for "qa user3"
    And presses the "Continue" button

    And user should be on "Payment & Review" tab
    Then user checks billing info for "qa user3"
