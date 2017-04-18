@pepBoys 

Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE

  Background: Set Up preconditions for testing billing page
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method


  @TestCaseId("15517")
  Scenario: Test field 'Apartment'
    Given user makes authorisation for "Moovweb QA"
    And user should be on "Billing & Shipping" tab
    And selects "Enters a New Address"
    And user types billing info for "user at Spear street" and checks email

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




