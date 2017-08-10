@saatva

Feature: SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    And presses the "Continue" button
    Then user should be on "Shipping" tab

  @TestCaseId("101030")
  @TestCaseId("101015")
  @TestCaseId("101067")
  Scenario: Test with correct shipping information and fill in all required fields (US Only)

    Given user types shipping address for "qa user" with phone number
    And user should see "United States" shipping country
    And chooses "Canada" country
    And user should see "Canada" shipping country
    And chooses "United States" country
    And user should see "United States" shipping country
    And presses the "Continue" button
    Then user should be on "Payment & Review" tab

