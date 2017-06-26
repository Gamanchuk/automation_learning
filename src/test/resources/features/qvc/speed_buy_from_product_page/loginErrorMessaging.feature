@qvc

Feature: SPEED BUY FROM PRODUCT PAGE

  Background: Add product to card and process to checkout
    Given user speed buy product


  @TestCaseId("")
  Scenario: Login error messaging

    Given user makes authorisation with "" email and "" password
    Then sees "FORM ERRORS" error message with text "Please review all inputs."

    Given user makes authorisation with "invalid@qwe.com" email and "invalid" password
    Then sees "FORM ERRORS" error message with text "Hmmm. The information you entered does not match our records. Please double-check and try again. For further assistance, call us at 888-345-5788 or visit Customer Service."

    Given user presses the Proceed to Guest Checkout link
    Then user should be on "Address" tab