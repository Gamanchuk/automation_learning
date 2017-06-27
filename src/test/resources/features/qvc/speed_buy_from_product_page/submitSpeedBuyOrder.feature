@qvc

Feature: SPEED BUY FROM PRODUCT PAGE

  Background: Add product to card and process to checkout
    Given user speed buy product

  @TestCaseId("")
  Scenario: Submit speed buy order
    Given user makes authorisation with "manytu3@i.ua" email and "q1q1w1w1" password
    And user should be on "Payment" tab
    And uses saved "visa" card for payment
    And presses the "Continue" button

    And user should be on "Review" tab
    And presses the "Place Order" button

    Then user should be on thank you page
    