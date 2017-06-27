@qvc @Ignored

Feature: EXISTING - REVIEW PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user fills email field with "manytu3@i.ua"
    And presses the "Continue" button
    And user checks "Using your default shipping and payment information?" checkbox
    And user fills password field with "q1q1w1w1"
    And presses the "Continue" button
    Then user should be on "Payment" tab


  @TestCaseId("")
  Scenario: Check Edit Shipping info

    #TODO: Need finish after George answer