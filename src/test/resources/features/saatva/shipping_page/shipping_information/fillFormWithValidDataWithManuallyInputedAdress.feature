@saatva

Feature: SHIPPING PAGE - Shipping Info

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

  @TestCaseId("101029")
  @TestCaseId("101015")
  Scenario: Test with correct shipping information and fill in all required fields (Address input manually)

    Given user types manually shipping address for "qa user"
    #And user types manually shipping address for "qa user"
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab



