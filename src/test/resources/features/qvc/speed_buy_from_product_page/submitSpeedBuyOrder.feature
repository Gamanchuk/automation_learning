@qvc

Feature: SPEED BUY FROM PRODUCT PAGE

  Background: Add product to card and process to checkout
    Given user speed buy product

  @TestCaseId("")
  Scenario: Submit speed buy order
    Given user makes authorisation with "yelena.poghosyan@moovweb.com" email and "Spear160!" password
    Then user should be on thank you page
    