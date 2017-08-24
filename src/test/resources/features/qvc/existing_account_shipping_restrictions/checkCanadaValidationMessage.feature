@qvc @Ignored

Feature: EXISTING ACCOUNT - SHIPPING RESTRICTIONS


  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    Then presses the "Continue" button

  @TestCaseId("101815")
  Scenario: Check Canada validation message

    Given user should be on "Address" tab
    #And unset checkbox "Yes, shipping address and billing address are the same"
    And selects "Enter a New Address" for shipping address
    Then chooses "Canada" country
    Then user should be see country note with text "We're sorry, shipping to Canada is not available."
