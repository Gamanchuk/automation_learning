@qvc @debug

Feature: GUEST - SHIPPING RESTRICTIONS


  @TestCaseId("101814")
  Scenario: Check default shipping country

    Given user adds to cart product
    Then user should be on "Address" tab
    And user should see "United States" shipping country
