@philosophy

Feature: GUEST - SHIPPING PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest

  @TestCaseId("17106")
  Scenario: Breadcrumb links redirect user to correct page

    Given user should be on "Shipping" tab

    And user presses "Delivery" breadcrumb tab
    Then user should stay at "Shipping" tab

    And user presses "Payment" breadcrumb tab
    Then user should stay at "Shipping" tab

    And user presses "Review" breadcrumb tab
    Then user should stay at "Shipping" tab