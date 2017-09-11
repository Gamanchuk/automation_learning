@philosophy

Feature: GET STARTED PAGE - SIGN IN

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as existing user


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

    Given user fills password field with "invalid"
    And  user fills email field with ""
    And sees error tooltip with text "Email can't be blank"
    And presses the "Sign In & Checkout" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."


    Given user fills password field with ""
    And sees error tooltip with text "Password can't be blank"
    And  user fills email field with ""
    And sees error tooltip with text "Email can't be blank"
    And presses the "Sign In & Checkout" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user fills password field with "Spear201!"
    And  user fills email field with ""
    And sees error tooltip with text "Email can't be blank"
    And presses the "Sign In & Checkout" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user fills password field with ""
    And sees error tooltip with text "Password can't be blank"
    And  user fills email field with "notqa@moovweb.com"
    And presses the "Sign In & Checkout" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user fills password field with "Spear201!"
    And  user fills email field with "notqa@moovweb.com"
    And presses the "Sign In & Checkout" button
    Then sees "FORM ERRORS" error message with text "email and password do not match our records."

    Given user fills password field with ""
    And sees error tooltip with text "Password can't be blank"
    And  user fills email field with "qa@moovweb.com"
    And presses the "Sign In & Checkout" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user fills password field with "invalid"
    And  user fills email field with "qa@moovweb.com"
    And presses the "Sign In & Checkout" button
    Then sees "FORM ERRORS" error message with text "email and password do not match our records."

    Given user fills password field with "invalid"
    And  user fills email field with "qa@moovweb.com"
    And presses the "Sign In & Checkout" button
    Then sees "FORM ERRORS" error message with text "email and password do not match our records."

    Given user fills password field with "invalid"
    And  user fills email field with "qamoovweb.com"
    And sees error tooltip with text "Email is not valid"
    And presses the "Sign In & Checkout" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."


   