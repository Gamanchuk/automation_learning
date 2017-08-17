@philosophy

Feature: GET STARTED PAGE - SIGN IN

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy


  @TestCaseId("82813")
  @TestCaseId("82814")
  @TestCaseId("82816")
  @TestCaseId("82817")
  @TestCaseId("82818")
  @TestCaseId("82819")
  @TestCaseId("82820")
  @TestCaseId("82821")
  @TestCaseId("82822")
  @TestCaseId("82826")

  Scenario: User can't sign in with incorrect/invalid/empty email address and password

    Given user makes authorisation with "" email and "invalid" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "" email and "" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "" email and "Spear201!" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "notqa@moovweb.com" email and "" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "notqa@moovweb.com" email and "Spear201!" password
    Then sees "FORM ERRORS" error message with text "email and password do not match our records."

    Given user makes authorisation with "qa@moovweb.com" email and "" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "qa@moovweb.com" email and "invalid" password
    Then sees "FORM ERRORS" error message with text "email and password do not match our records."

