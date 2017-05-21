@pepBoys

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - BILLING INFO

  Background: Set Up preconditions for testing billing page
    Given user makes appoint
    And user adds to cart product with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15517")
  Scenario: Test field 'Apartment'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enter a New Address"
    And user types billing info for "qa user" and checks email

    And user types " " into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks "Apt, Bldg." with value "" on "Payment & Review" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "12345" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks "Apt, Bldg." with value "12345" on "Payment & Review" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "Some Apartment" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks "Apt, Bldg." with value "Some Apartment" on "Payment & Review" tab
    And user navigates to "Billing & Shipping" breadcrumb

    And user types "!#&@()" into the "Apt, Bldg." field of "Billing Address" address form
    And presses the "Continue" button
    Then user checks "Apt, Bldg." with value "!#&@()" on "Payment & Review" tab




