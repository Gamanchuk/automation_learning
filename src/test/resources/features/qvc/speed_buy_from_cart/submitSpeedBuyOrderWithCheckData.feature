@qvc

Feature: SPEED BUY FROM CART

  Background: Add product to card and process to checkout
    Given user adds to cart product and speed buy
    And user fills email field with "gamanchuk.aleksey@moovweb.com"
    And presses the "Continue" button
    And user checks "Using your default shipping and payment information?" checkbox
    And user fills password field with "asdffdsA1"
    And presses the "Continue" button
    Then user should be on "Review" tab

  @TestCaseId("")
  Scenario: Submit speed buy order with check data
    Given presses the "Place Order" button
    Then user should be on thank you page

    