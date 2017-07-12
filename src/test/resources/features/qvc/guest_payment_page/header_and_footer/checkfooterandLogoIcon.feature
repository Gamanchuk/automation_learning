@qvc

Feature: GUEST - PAYMENT PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product
    And user continue checkout as guest
    And presses the "Continue" button
    And user should be on "Address" tab
    And user types billing info for "qa user" without email
    And presses the "Continue" button
    And chooses "Use Entered Address"
    And user should be on "Delivery" tab
    And presses the "Continue" button
    Then user should be on "Payment" tab


  @TestCaseId("102350")
  @TestCaseId("102347")
  @TestCaseId("102346")
  Scenario: Check Footer and Logo Icon

    Given user checks support number with label "1-888-345-5788" and number "1-888-345-5788"
    And user checks text "©1995-2017 QVC, Inc. All rights reserved." in footer
    And user presses the logo
    Then user should be on QVC main page

