@qvc

Feature: CONTACT PAGE

  Background: Add product to card and process to checkout
    Given user adds to cart product from Saatva


  @TestCaseId("101059")
  Scenario: Test contact form with blank fields (error message should be displayed)

    Given user continue checkout as guest
