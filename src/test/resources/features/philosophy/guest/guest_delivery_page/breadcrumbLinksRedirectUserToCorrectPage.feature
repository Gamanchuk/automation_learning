@philosophy @debug

Feature: GUEST - DELIVERY PAGE

  Background: Add product to card and process to checkout
    Given user adds product to cart from Philosophy
    And chooses "Checkout" method from Philosophy
    And user continue checkout as guest
    Then user should be on "Shipping" tab
    And user types shipping info for "qa user" without email
    And presses the "Continue" button
    Then user should be on "Delivery" tab


  @TestCaseId("")
  Scenario: Breadcrumb links redirect user to correct page

    And user presses "Payment" breadcrumb tab
    Then user should stay at "Delivery" tab

    And user presses "Review" breadcrumb tab
    Then user should stay at "Delivery" tab


    And user presses "Shipping" breadcrumb tab
    Then user should be on "Shipping" tab