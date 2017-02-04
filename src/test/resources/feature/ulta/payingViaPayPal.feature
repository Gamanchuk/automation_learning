@testdiary


Feature: Customer Search Product
  As a customer,
  I want to search product
  and pay this product


  Scenario: Pay with PayPal
    Given the user go to page "http://qa1.ulta.com/?_mwexperienceid=bc6692b3-6dfe-4c87-b334-0065aff58167"
    When he enters "2294863" in search field and submit
    And ensure the product "2294863" found
    And add product to bag
    And view and check out bag
    And he enters/apply coupon "ORAMT2CPN"
    And check out with paypal
    And he choice/apply random sample
    And he login on paypal "manytu2012-buy@gmail.com" , "q1q1q1q1"
    And he confirmation pay
    And he enter "some@gmail.com" for continue as guest
    Then he check price "$29.93" order
    And click button Place Order