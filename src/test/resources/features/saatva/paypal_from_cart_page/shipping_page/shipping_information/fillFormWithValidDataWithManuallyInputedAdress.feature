@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab

  @TestCaseId("101871")
  @TestCaseId("101882")
  @TestCaseId("101933")
  @TestCaseId("101879")
  @TestCaseId("101886")
  Scenario: Test with correct shipping information and fill in all required fields (Address input manually)

    Given user types manually shipping info for "qa user2" with phone number 
    #And user types manually shipping address for "qa user"
    And user types "4154154156" into the "Phone Number" field of "Shipping Address" address form

    And user should see "United States" shipping country
    And chooses "Canada" country
    And user should see "Canada" shipping country
    And chooses "United States" country
    And user should see "United States" shipping country

    And selects "" state
    And presses the "Continue" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."
    And selects "CA" state
    And presses the "Continue" button

    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab



