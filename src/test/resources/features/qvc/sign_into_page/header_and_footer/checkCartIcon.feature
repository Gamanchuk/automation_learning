@qvc

Feature: SIGN IN PAGE - HEADER & FOOTER

  Background: Add product to card and process to checkout
    Given user adds to cart product


  @TestCaseId("102360")
  Scenario: Check Cart Icon

    Given user continue checkout as guest
    And user presses the Shopping Cart icon
    Then user should be on QVC cart page

