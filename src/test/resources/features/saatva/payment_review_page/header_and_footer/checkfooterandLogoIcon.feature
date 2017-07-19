@saatva

Feature: PAYMENT & REVIEW - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds product to cart from Saatva
    And chooses "Checkout" method on Saatva cart page
    And user should be on "Contact" tab
    And user fill contact details as "qa user"
    And presses the "Continue" button
    Then user should be on "Shipping" tab


  @TestCaseId("101070")
  @TestCaseId("101072")
  @TestCaseId("101073")
  Scenario: Check footer and Logo Icon
    Given user types shipping address for "qa user" with phone number
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Payment & Review" tab

    When user checks support number with label "1-877-672-2882" and number "18776722882"
    And user checks text "© Copyright 2017 - Saatva" in footer
    And user presses the logo
    Then user should be on Saatva main page