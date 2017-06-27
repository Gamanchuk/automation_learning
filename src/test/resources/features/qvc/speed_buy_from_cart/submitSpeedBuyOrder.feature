@qvc

Feature: SPEED BUY FROM CART

  Background: Add product to card and process to checkout
    Given user adds to cart product and speed buy

  @TestCaseId("")
  Scenario: Submit speed buy order
    Given user makes authorisation with "gamanchuk.aleksey@moovweb.com" email and "asdffdsA1" password
    And user should be on "Payment" tab
    And uses saved "visa" card for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    And presses the "Place Order" button

    Then user should be on thank you page
    