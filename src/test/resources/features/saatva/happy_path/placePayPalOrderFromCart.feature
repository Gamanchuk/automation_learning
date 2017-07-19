@saatva @debug

Feature: HAPPY PATH - PAYPAL EXPRESS FROM CART PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal
    #And user confirms purchase with PayPal
    And user should be on "Shipping" tab
    And user types "4152011234" into the "Phone Number" field of "Shipping Address" address form
    And presses the "Continue" button
    Then chooses "Use Entered Address"


  @TestCaseId("100976")
  Scenario: Place order as guest with PayPal Express
    Given user should be on "Payment & Review" tab

    Then presses the "Place Order" button