@qvc

Feature: GUEST - SHIPPING & BILLING PAGE - SHIPPING INFO

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    Then user should be on "Address" tab


  # TODO: ask, if we should check this case
  @TestCaseId("")
  Scenario: Test field 'Zip Code'
    Given user types manually billing info for "qa user" without email
    And user types shipping address for "qa user"

    And user types "" into the "Zip Code" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should stay at "Address" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And user types "94105" into the "Zip Code" field of "Shipping Address" address form
    And presses the "Continue" button
    Then user should be on "Delivery" tab