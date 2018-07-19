@ignore
Feature: Add a product to shopping cart
  As a user
  I want to receive a confirmation banner when I add a product to my cart
  So that I know I added the right product

  Background: product page
    Given I am on a product page

  Scenario: Successful addition - confirmation banner
    Given there is product available
    When I add the product to my shopping cart
    Then I should see a confirmation banner

  Scenario: Unsuccesful addition - product not available
    Given there is no product available
    When I add the product to my shopping cart
    Then I should NOT see a confirmation banner
    And I should see a message telling me there is no product available


