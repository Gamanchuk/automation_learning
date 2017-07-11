@saatva

Feature: CONTACT PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product from Saatva

  @TestCaseId("101046")
  @TestCaseId("101048")
  @TestCaseId("101049")
  @TestCaseId("102565")
  Scenario: Check footer and Logo Icon

    When user checks support number with label "1-877-672-2882" and number "18776722882"
    And user checks text "© Copyright 2017 - Saatva" in footer
    And user presses the logo
    Then user should be on Saatva main page