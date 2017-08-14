@saatva

Feature: SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    And presses the "Continue" button
    Then user should be on "Shipping" tab

  @TestCaseId("101029")
  @TestCaseId("101015")
  @TestCaseId("101037")
  Scenario: Test with correct shipping information and fill in all required fields (Address input manually)

    Given user types manually shipping info for "qa user" with phone number
    And user types "4152011234" into the "Phone Number" field of "Shipping Address" address form
    And selects "" state
    And presses the "Continue" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."
    And selects "CA" state
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab



