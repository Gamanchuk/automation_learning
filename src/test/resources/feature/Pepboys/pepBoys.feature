@pepBoys

Feature: Customer Search Product
  As a customer,
  I want to search product
  and pay this product


  Scenario: PepBoys test
    #Given user go to page "https://mstage.pepboys.com/?moov_=237a6e27-ceac-41f5-aedc-8e90a6696efd"
    Given user go to page "https://mstage.pepboys.com/?_mwexperienceid=b337455a-a439-4ef9-a844-8c48ecde9c3b"
    When he enters "555667" in search field
    And accept ship to home & add product to bag
    And user check out with PayPal
    And he login on paypal "qateam@moovweb.com" , "Spear160!"
    And he confirmation pay
    And continue pay
#    Then he check price "$29.93" order
#    And click button Place Order