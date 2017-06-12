@qvc @debug

Feature: GUEST - SHIPPING & BILLING PAGE - BILLING INFO - INTERNATIONAL

  Background: Add product to card and process to checkout
    Given user adds to cart product

  @TestCaseId("")
  Scenario: Test with correct billing information and fill in all required fields (Address inputted manually)
    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And chooses "Canada" country
    And user types manually international billing info for "qa canada" without email

    And user types "qa moovweb" into the "Full Name" field of "Shipping Address" address form
    And user types "123 Mission Street" into the "Street Address" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab
