@pepBoys @debug

Feature: PAY IN STORE - EXISTING ACCOUNT - SHIPPING & BILLING PAGE

  Background: Set Up preconditions for testing billing page
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16633")
  Scenario: Test field 'Apartment'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"
    And user types billing info for "qa user" and checks email

    And user types "" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks "Apt, Bldg." with value "" on "Delivery Method" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "12345" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks "Apt, Bldg." with value "12345" on "Delivery Method" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "Some Apartment" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks "Apt, Bldg." with value "Some Apartment" on "Delivery Method" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "!#&@()" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks "Apt, Bldg." with value "!#&@()" on "Delivery Method" tab




