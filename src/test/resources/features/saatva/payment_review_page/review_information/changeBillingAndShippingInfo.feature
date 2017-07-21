@saatva

Feature: GUEST - REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

    @TestCaseId("101018")
    @TestCaseId("101019")
    @TestCaseId("101021")
    @TestCaseId("101022")
    @TestCaseId("101023")
    @TestCaseId("101021")
    @Issue("MCCAT-6381")
  Scenario: Change billing, shipping and contact info
    Given user types shipping address for "qa user" with phone number
    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab

#    Then user should see "Billing Address" form
#    And user clicks arrow for "Customer Information"
#    And user should be on "Contact" tab
#    And user fill contact details as "qa user2"
#    And presses the "Continue" button
#    And user should be on "Payment & Review" tab

    And user clicks arrow for "Billing Address"
    And user should be on "Shipping" tab
    And user types manually shipping info for "qa user2" with phone number
    And user types manually billing info for "qa user2" with phone number
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab




