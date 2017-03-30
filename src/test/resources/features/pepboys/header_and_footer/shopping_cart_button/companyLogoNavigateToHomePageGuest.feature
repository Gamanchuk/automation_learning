@pepBoys @debug


Feature: Header and Footer

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15368")
  Scenario: Company Logo navigate to home page (Guest User, Pay Online)

    # From Billing & Shipping tab
    Given user press the Shopping Cart icon
    Then user should be navigate to cart page

    # From Delivery Method tab
    Given chooses "Pay Online" method
    And user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground" shipping method
    And user press the Shopping Cart icon
    Then user should be navigate to cart page

    # From Payment & Review tab

    Given chooses "Pay Online" method
    And user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment
    And user press the Shopping Cart icon
    Then user should be navigate to cart page

    # From login page

    Given chooses "Pay Online" method
    And user press the signIn button
    And user press the Shopping Cart icon
    Then user should be navigate to cart page

    #======#

  # From Billing & Shipping tab (Existing Acco Given user navigates to cart page
    Given chooses "Pay Online" method
    And user makes authorisation for "qa user"
    And user press the Shopping Cart icon
    Then user should be navigate to cart page
    And user logOut from checkout

    # From Delivery Method tab (Existing Account)
    Given user navigates to cart page
    And chooses "Pay Online" method
    And user makes authorisation for "qa user"
    And applies billing info for address "123 Mission Street, 10th Floor"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground" shipping method
    And user press the Shopping Cart icon
    Then user should be navigate to cart page
    And user logOut from checkout

    # From Payment & Review tab (Existing Account)

    Given user navigates to cart page
    And chooses "Pay Online" method
    And user makes authorisation for "qa user"
    And applies billing info for address "201 SPEAR ST"
    And presses the "Continue" button
    And chooses "Use Recommended Address"
    And chooses "Ground" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment
    And user press the Shopping Cart icon
    Then user should be navigate to cart page
    And user logOut from checkout

