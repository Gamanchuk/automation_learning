@qvc

Feature: EXISTING ACCOUNT - REVIEW PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102377")
  @TestCaseId("102378")
  @TestCaseId("102379")
  @TestCaseId("102381")
  Scenario: Check footer and Logo Icon

    Given user continue checkout as "qa user"

    And presses the "Continue" button
    And user should be on "Address" tab

    And presses the "Continue" button
    And user should be on "Delivery" tab
    And presses the "Continue" button

    Then user should be on "Payment" tab
    And uses "Pay with Check / Money Order" for payment
    And presses the "Continue" button
    And user should be on "Review" tab

    And user checks support number with label "1-888-345-5788" and number "1-888-345-5788"
    And user checks text "©1995-2017 QVC, Inc. All rights reserved." in footer
    And user presses the logo
    Then user should be on QVC main page