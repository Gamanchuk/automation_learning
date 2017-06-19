@qvc @Ignored

Feature: GUEST - PAYMENT PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("102461")
  @TestCaseId("102031")
  @TestCaseId("102032")
  @TestCaseId("102460")
  @TestCaseId("101794")
  Scenario: Test Valid Gift Card

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user types billing info for "qa user"
    And presses the "Continue" button

    And user should be on "Delivery" tab
    And presses the "Continue" button

    And user should be on "Payment" tab
    And user types gift card with "6006496688749904607" number and "0809" pin code
    And presses the "Apply" button

    #TODO: Gift cards not valid
    #And user clicks Gift Cards modal link
    #Then user should see Gift Cards modal with "QVC Gift Cards"
    #And user clicks modal close button
    #And uses "mastercard" card for payment
    #update so that the user can enter negative test first
    #then user enters multiple cards
    #user confirms pop-up