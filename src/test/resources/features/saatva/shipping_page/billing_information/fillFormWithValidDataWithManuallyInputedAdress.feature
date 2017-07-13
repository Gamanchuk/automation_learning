@saatva @debug

Feature: SHIPPING PAGE - Billing Info

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

  @TestCaseId("")
  Scenario: Test with correct shipping information and fill in all required fields (Address input manually)
    Given user types shipping address for "qa user" with phone number
    And unset checkbox "Yes, billing address and shipping address are the same"
    
    And user types manually billing info for "qa user" without email
    #And user types manually shipping address for "qa user"
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab


