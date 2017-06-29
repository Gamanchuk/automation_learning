@qvc

Feature: SPEED BUY FROM CART

  Background: Add product to card and process to checkout
    Given user adds to cart product and speed buy

  @TestCaseId("")
  Scenario: Submit speed buy order
    Given user makes authorisation with "gamanchuk.aleksey@moovweb.com" email and "asdffdsA1" password
    Then user should be on thank you page

    