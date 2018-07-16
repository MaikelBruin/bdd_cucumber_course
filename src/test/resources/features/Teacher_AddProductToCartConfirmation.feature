@smoke
Feature: Receive confirmation when adding to cart

  As user of the webshop
  I would like to see a confirmation when I add products to my shopping cart
  So that I know that I added the right product

  Scenario: Receive confirmation when adding products to the shopping cart
    Given   I am on the Polteq Webshop
    When    I go to the IPODS page
    And     I go to the iPod Nano detail page
    And     I add the iPod Nano to the cart
    Then    I get a confirmation that the product is added to the shopping cart
    But     I should not be taken directly to my shopping cart

#  Scenario: The Add to product to cart button is visible for each product on the homepage
#    Given I am on the Polteq Webshop
#    And The homepage displays products
#    Then I can see the add to cart button for each product
#
#  Scenario: I can change the quantity of products added to the cart
#    Given I am on the Polteq Webshop
#    When I go to the IPODS page
#    And I go to the iPod Nano detail page
#    And I change the quantity to 4
#    And I add the iPod Nano to the cart
#    Then I get a confirmation that the set quantity of products are added to the cart
#
#  Scenario: I can see if the item is in stock before I add the product to the cart
#    Given I am on the Polteq Webshop
#    When I go to the IPODS page
#    And I go to the iPod Nano detail page
#    Then I am able to see if the item is in stock
