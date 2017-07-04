@qvc @debug

Feature: GUEST - PAYMENT PAGE - QCARD

  Background:
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And presses the "Continue" button

  @TestCaseId("101823")
  @TestCaseId("101824")
  @TestCaseId("101829")
  @TestCaseId("101830")
  Scenario: Test QCard fields and format
    Given user should be on "Payment" tab
    And uses "partial-qcard" card for payment
    And presses the "Continue" button
    And sees "FORM ERRORS" error message with text "Please review all inputs."

    And uses "qcardNEW" card for payment
    And presses the "Continue" button
    Then user should be on "Review" tab
    And user presses "Payment" breadcrumb tab
    Then user should be on "Payment" tab

    Then user should see "Payment Options" form
    And selects "Enter a New Card"
    And uses "qcard" card for payment
    #TODO remember to use an easy pay item for easy pay cases!
    # And user should be on "Payment Options" page

    And presses the "Continue" button
    Then user should be on "Review" tab



