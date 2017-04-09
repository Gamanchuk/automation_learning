@pepBoys

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

    Given user makes authorisation with "" email and "invalid" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "" email and "" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "" email and "Spear201!" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "notqa@moovweb.com" email and "" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "notqa@moovweb.com" email and "Spear201!" password
    Then sees "FORM ERRORS" error message with text "Your login attempt was not successful, try again."

    Given user makes authorisation with "qa@moovweb.com" email and "" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "qa@moovweb.com" email and "invalid" password
    Then sees "FORM ERRORS" error message with text "Your login attempt was not successful, try again."

    Given user presses the Proceed to Guest Checkout link
    Then user should be on "Billing" page