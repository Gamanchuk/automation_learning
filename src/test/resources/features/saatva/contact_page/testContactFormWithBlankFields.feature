@saatva

Feature: CONTACT PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product from Saatva



  @TestCaseId("101059")
  Scenario: Test contact form with blank fields (error message should be displayed)

    Given user should be on "Contact" tab
    And presses the "Continue" button
    Then user should stay at "Contact" tab
    And sees "FORM ERRORS" error message with text "Please review all inputs."