@saatva

Feature: SHIPPING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    Then presses the "Continue" button

  @TestCaseId("101033")
  @TestCaseId("101015")
  @TestCaseId("101041")
  Scenario: Test field 'Last name'
    Given user types shipping address for "qa user" with phone number

    And user types "Moovweb" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Shipping" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "qa qwertyuioplkjhgfdsazxcvbnm" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab
    And user presses "Shipping" breadcrumb tab
    Then user should be on "Shipping" tab

    And user types "Moovweb !@#&::!@#()" into the "Full Name" field of "Shipping Address" address form
    And presses the "Continue" button
    And chooses "Use Entered Address"
    Then user should be on "Payment & Review" tab



