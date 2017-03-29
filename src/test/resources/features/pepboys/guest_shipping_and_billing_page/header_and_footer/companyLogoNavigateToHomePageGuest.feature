@pepBoys


Feature: Header and Footer

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15368")
  Scenario: Company Logo navigate to home page (Guest User)

    # From Billing & Shipping tab
    Given user press the logo
    Then user should be navigate to main page

    # From login page
    Given user navigates to cart page
    And chooses "Pay Online" method
    And user press the signIn button
    And user press the logo
    Then user should be navigate to main page

    # From Delivery Method tab
    Given user navigates to cart page
    And chooses "Pay Online" method
    And user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground" shipping method
    And user press the logo
    Then user should be navigate to main page

    # From Payment & Review tab
    Given user navigates to cart page
    And chooses "Pay Online" method
    And user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment
    And user press the logo
    Then user should be navigate to main page


