@saatva

Feature: EXPRESS PAYPAL CHECKOUT - THANK YOU PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "PayPal" method on Saatva cart page
    And user confirms purchase as "qa user" with PayPal

    And user should be on "Shipping" tab
    And user types "4154154156" into the "Phone Number" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab
    And presses the "Place Order" button
    Then user should be on thank you page

  @TestCaseId("101226")
  @TestCaseId("101227")
  @TestCaseId("101228")
  @TestCaseId("101230")
  @TestCaseId("101233")
  @TestCaseId("101236")
  @TestCaseId("101229")
  @TestCaseId("101233")
  Scenario: Thank you page format, content, functionality

    When user checks support number with label "1-877-672-2882" and number "18776722882"
    And user checks text "Copyright © 2010-2017 Saatva, Inc." in footer
    And user can expand and collapse Order summary on Thank You page
    And presses the "Continue Shopping" button

    #TODO: add back functionality to test the header logo as well in one test
    #And user presses the logo
    Then user should be on Saatva main page