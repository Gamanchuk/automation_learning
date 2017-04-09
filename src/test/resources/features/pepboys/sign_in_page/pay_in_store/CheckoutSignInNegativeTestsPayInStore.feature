@pepBoys @debug

Feature: Sign In page (Pay in Store)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8536868" with "Pick Up in Store" delivery option
    And user views cart
    And chooses "Pay in Store" method
    And user presses the signIn button


  @TestCaseId("16684")
  @TestCaseId("16681")
  @TestCaseId("16682")
  @TestCaseId("16685")
  @TestCaseId("16680")
  @TestCaseId("16683")
  @TestCaseId("16679")
  @TestCaseId("16676")
  Scenario: User can't sign in with incorrect/invalid/empty email address and password (Pay in Store)

    Given user email "" password "invalid" makes authorisation
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user email "" password "" makes authorisation
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user email "" password "Spear201!" makes authorisation
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user email "notqa@moovweb.com" password "" makes authorisation
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user email "notqa@moovweb.com" password "Spear201!" makes authorisation
    Then sees "FORM ERRORS" error message with text "Your login attempt was not successful, try again."

    Given user email "qa@moovweb.com" password "" makes authorisation
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user email "qa@moovweb.com" password "invalid" makes authorisation
    Then sees "FORM ERRORS" error message with text "Your login attempt was not successful, try again."

    Given user presses the Proceed to Guest Checkout link
    Then user should be on "Billing" page