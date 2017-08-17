@saatva @debug

Feature: PAYMENT & REVIEW - THANK YOU PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button
    And user types shipping address for "qa user" with phone number
    And unset checkbox "Yes, billing address and shipping address are the same"
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab
    And uses "mastercard" card for payment
    And presses the "Place Order" button
    Then user should be on thank you page

  @TestCaseId("101008")
  @TestCaseId("101009")
  @TestCaseId("101010")
  @TestCaseId("101011")
  @TestCaseId("101012")
  @TestCaseId("101075")
  @TestCaseId("101077")
  @TestCaseId("101078")
  Scenario: Thank you page format, content, functionality

    When user checks support number with label "1-877-672-2882" and number "18776722882"
    And user checks text "Copyright © 2010-2017 Saatva, Inc." in footer
    And user can expand and collapse Order summary on Thank You page
    And presses the "Continue Shopping" button

    #TODO: add back functionality to test the header logo as well in one test
    #And user presses the logo
    Then user should be on Saatva main page