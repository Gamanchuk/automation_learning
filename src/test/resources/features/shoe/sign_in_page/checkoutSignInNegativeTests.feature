@shoe

Feature: SIGN IN PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Shoe
    And user presses the signIn button


  @TestCaseId("16507")
  @TestCaseId("16508")
  @TestCaseId("16509")
  @TestCaseId("16510")
  @TestCaseId("16511")
  @TestCaseId("16512")
  @TestCaseId("16513")
  @TestCaseId("16514")
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
    Then sees "FORM ERRORS" error message with text "Whoops! Please try again. The email address you entered is incorrect."

    Given user makes authorisation with "qa@moovweb.com" email and "" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "qa@moovweb.com" email and "invalid" password
    Then sees "FORM ERRORS" error message with text "Whoops! Please try again. The password you entered is incorrect."

    And user presses the Proceed to Guest Checkout link
    Then user should be on "Shipping" tab
