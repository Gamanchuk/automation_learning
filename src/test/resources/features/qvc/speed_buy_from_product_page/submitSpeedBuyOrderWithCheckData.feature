@qvc

Feature: SPEED BUY FROM PRODUCT PAGE

  Background: Add product to card and process to checkout
    Given user speed buy product
    And user fills email field with "gamanchuk.aleksey@moovweb.com"
    And user checks "Using your default shipping and payment information?" checkbox
    And user fills password field with "asdffdsA1"
    And presses the "Continue" button
    Then user should be on "Review" tab

  @TestCaseId("")
  Scenario: Submit speed buy order
    Given presses the "Place Order" button
    Then user should be on thank you page
    