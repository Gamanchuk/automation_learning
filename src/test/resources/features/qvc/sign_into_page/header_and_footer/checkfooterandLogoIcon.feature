@qvc

Feature: SIGN IN PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102361")
  @TestCaseId("102362")
  @TestCaseId("102363")
  @TestCaseId("102364")
  Scenario: Check footer and Logo Icon

    Given user continue checkout as guest

    And user checks support number with label "1-888-345-5788" and number "1-888-345-5788"
    And user checks text "©1995-2017 QVC, Inc. All rights reserved." in footer
    And user presses the logo
    Then user should be on QVC main page