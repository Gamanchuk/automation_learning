@qvc

Feature: SPEED BUY FROM CART

  Background: Add product to card and process to checkout
    Given user adds to cart product and speed buy
    And user fills email field with "yelena.poghosyan@moovweb.com"
    And user checks "I would like to review the order total (with shipping and handling and applicable tax included) or edit my order before I submit it." checkbox
    And user fills password field with "Spear160!"
    And presses the "Place Order" button
    Then user should be on "Review" tab

  @TestCaseId("")
  Scenario: Submit speed buy order with check data
    Given presses the "Place Order" button
    Then user should be on thank you page

    