@ignore
Feature: Add a product to shopping cart
  As a user
  I want to receive a confirmation banner when I add a product to my cart
  So that I know I added the right product

  Background: product page
    Given I am on a product page

  Scenario: Succesful addition - shopping cart filled
    Given there is product available
    And my shopping cart is empty
    When I add the product to my shopping cart
    Then my shopping cart should not be empty

  Scenario: Unsuccesful addition - product not available
    Given there is no product available
    And my shopping cart is empty
    When I add the product to my shopping cart
    Then my shopping cart should be empty
