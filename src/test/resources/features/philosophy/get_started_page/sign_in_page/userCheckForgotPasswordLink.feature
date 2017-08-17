@philosophy

Feature: GET STARTED PAGE - SIGN IN

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user makes authorisation with "" email and "" password


  @TestCaseId("82867")
  @TestCaseId("82829")
  @TestCaseId("82869")
  @TestCaseId("82870")
  Scenario: User can click on Forgot Password link
    Given user presses the Forgot Password link
    And user should be see Password Assistance

    And user fills email field with ""
    And presses the "Request Password" button
    Then sees error tooltip with text "Email can't be blank"

    And user fills email field with "qamoovweb.com"
    And presses the "Request Password" button
    Then sees error tooltip with text "Email is not valid"

    And user fills email field with "auto@moovweb.com"
    And presses the "Request Password" button
    Then sees "ERROR" error message with text "email address does not exist."

    Then user presses the "Cancel Request" link

    Given user makes authorisation for "qa user"
    Then user should be on "Shipping" tab

    