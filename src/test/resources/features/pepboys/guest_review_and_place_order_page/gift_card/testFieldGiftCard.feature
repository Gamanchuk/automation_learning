@pepBoys @debug

Feature: GUEST - REVIEW & PLACE ORDER PAGE - GIFT CARD

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method

  @TestCaseId("")
  Scenario: Test field "Gift Card" when user enter Invalid Gift Card
    Given user types billing info for "qa user"
    And presses the "Continue" button
    And chooses "Ground: 5-7 Days" shipping method
    And presses the "Continue" button
    And uses "visa" card for payment

    And user types gift card with "123123123" number and "1233" pin code
    And presses the "Apply" button
    Then sees "ERROR" error message with text "We did not recognize your gift card."
    And presses the "OK, I'll Try Again" button

  #  And presses the "Place Order" button
   # Then user should be on thank you page
