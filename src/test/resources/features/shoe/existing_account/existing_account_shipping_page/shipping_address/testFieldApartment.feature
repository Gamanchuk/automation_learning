@shoe

Feature: EXISTING ACCOUNT - SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user makes authorisation for "qa user"
    Then user should be on "Shipping" tab
    And user types shipping info for "qa user" without email
    Then unset checkbox "Save this address to my address book"


  @TestCaseId("16752")
  Scenario: Test field 'Apartment'

    Given user types "" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And user navigates to "Shipping" breadcrumb

    And user types "12345" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment" tab
    And user navigates to "Shipping" breadcrumb

    And user types "Some Apartment" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Payment" tab
    And user navigates to "Shipping" breadcrumb

    And user types "!#&@()" into the "Apt, Bldg." field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment" tab



