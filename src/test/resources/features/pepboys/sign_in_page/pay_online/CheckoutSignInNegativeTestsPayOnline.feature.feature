@pepBoys

Feature: Sign In page (Pay Online)

  Background:
    Given user makes appoint
    And user adds to cart product with id "8076476" with "Ship to Home" delivery option
    And user views cart
    And chooses "Pay Online" method
    And user presses the signIn button


  @TestCaseId("15535")
  @TestCaseId("15532")
  @TestCaseId("15533")
  @TestCaseId("15536")
  @TestCaseId("15531")
  @TestCaseId("15534")
  @TestCaseId("15530")
  @TestCaseId("15527")
  Scenario: User can't sign in with incorrect/invalid/empty email address and password (Pay Online)

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

    And user presses the Proceed to Guest Checkout link
    Then user should be on "Billing & Shipping" tab