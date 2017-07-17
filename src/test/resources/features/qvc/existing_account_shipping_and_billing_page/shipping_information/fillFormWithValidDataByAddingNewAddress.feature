@qvc


Feature: EXISTING ACCOUNT - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    Then user should be on "Address" tab


  @TestCaseId("102411")
  Scenario: Test with correct shipping information and fill in all required fields

    Given selects "Enter a New Address" for shipping address
    And user types shipping info for "user at Spear street" without email, phone
    And unset checkbox "Save this address to my address book"
    And presses the "Continue" button

    And chooses "Use Recommended Address"
    Then user should be on "Delivery" tab




