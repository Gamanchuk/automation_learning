@qvc

Feature: GUEST - SHIPPING & BILLING ADDRESS PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102356")
  @TestCaseId("102358")
  @TestCaseId("102359")
  @TestCaseId("102543")
  Scenario: Check footer and Logo Icon

    Given user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab

    And user checks support number with label "1-888-345-5788" and number "1-888-345-5788"
    And user checks text "©1995-2017 QVC, Inc. All rights reserved." in footer
    And user presses the logo
    Then user should be on QVC main page