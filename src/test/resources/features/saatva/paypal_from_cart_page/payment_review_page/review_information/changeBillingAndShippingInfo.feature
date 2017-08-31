@saatva

Feature: EXPRESS PAYPAL CHECKOUT - REVIEW PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user presses Log In PayPal button
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab
    And user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And user types "123 mission st ste 1020" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    And user should be on "Payment & Review" tab

    @TestCaseId("101191")
    @TestCaseId("101192")
    @TestCaseId("101189")
    @TestCaseId("101860")
    @TestCaseId("101189")
    @TestCaseId("")
    @Issue("MCCAT-6381")
  Scenario: Change billing, shipping and contact info
    Given user navigates to "Shipping" breadcrumb
      And user should be on "Shipping" tab
    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user2" without email
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




