@pepBoys, @debug


Feature: Some feature

  Background:
    Given user makes appoint with code "94105"
    And user add to cart product with id "8536851" with "Pick Up in Store (No Install)" delivery option
    And user views cart
    And chooses "Pay in Store" method

  @TestCaseId("16254")
  Scenario:Place order that must be pay in store
    Given user types billing info for "qa user" with confirmation method "Place Order"
    Then user should be on thank you page