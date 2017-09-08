@pepBoys

Feature: SIGN IN PAGE

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
  Scenario: User can't sign in with incorrect/invalid/empty email address and password

    Given user makes authorisation with " " email and "invalid" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with " " email and "" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with " " email and "Spear201!" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "notqa@moovweb.com" email and " " password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "notqa@moovweb.com" email and "Spear201!" password
    Then sees "FORM ERRORS" error message with text "email and password do not match our records."

    Given user makes authorisation with "qa@moovweb.com" email and "" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "qa@moovweb.com" email and "invalid" password
    Then sees "FORM ERRORS" error message with text "Your login attempt was not successful, try again."

    And user presses the Proceed to Guest Checkout link
    Then user should be on "Billing & Shipping" tab
