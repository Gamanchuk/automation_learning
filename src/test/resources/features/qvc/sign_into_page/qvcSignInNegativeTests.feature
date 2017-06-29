@qvc

Feature: SIGN IN PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102421")
  @TestCaseId("102422")
  @TestCaseId("102423")
  @TestCaseId("102424")
  @TestCaseId("102425")
  @TestCaseId("102426")
  @TestCaseId("102427")
  Scenario: User can't sign in with incorrect/invalid/empty email address and password
    Given user fills email field with ""
    And presses the "Continue" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user fills email field with "invalidemail"
    And presses the "Continue" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user fills email field with "manytu3@i.ua"
    And presses the "Continue" button
    Then user should see password field
    
    Given user fills email field with ""
    And user fills password field with ""
    And presses the "Continue" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user fills email field with ""
    And user fills password field with "Spear201!"
    And presses the "Continue" button
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user fills email field with "manytu3@i.ua"
    And user fills password field with ""
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user fills email field with ""
    And user fills password field with "invalid"
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user fills email field with "invalid"
    And user fills password field with ""
    Then sees "FORM ERRORS" error message with text "Please review all inputs."


