@qvc

Feature: GUEST - SHIPPING & BILLING ADDRESS PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as "qa user"
    And presses the "Continue" button
    And user should be on "Address" tab
    And presses the "Continue" button
    Then user should be on "Delivery" tab
    And presses the "Continue" button
    And user should be on "Payment" tab

  @TestCaseId("102266")
  @TestCaseId("102267")
  @TestCaseId("102268")
  @TestCaseId("102270")
  Scenario: Check footer and Logo Icon

    When user checks support number with label "1-888-345-5788" and number "1-888-345-5788"
    And user checks text "©1995-2017 QVC, Inc. All rights reserved." in footer
    And user presses the logo
    Then user should be on QVC main page
