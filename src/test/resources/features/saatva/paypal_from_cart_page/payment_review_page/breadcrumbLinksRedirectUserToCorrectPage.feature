@saatva

Feature: EXPRESS PAYPAL CHECKOUT - SHIPPING PAGE - BREADCRUMB

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

  @TestCaseId("101190")
  Scenario: Breadcrumb links redirect user to correct page

    Given user presses "Payment & Review" breadcrumb tab
    Then user should stay at "Payment & Review" tab

    And user presses "Contact" breadcrumb tab
    Then user should be on "Contact" tab

    And presses the "Continue" button
    #And user should be on "Shipping" tab

    #TODO: confirm breadcrumb behavior for paypal
    #And user presses "Shipping" breadcrumb tab
    #And user should be on "Shipping" tab
    #And presses the "Continue" button

    #And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab