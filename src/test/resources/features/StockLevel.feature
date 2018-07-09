Feature: Show stock level of product

  As user of the webshop
  I want to see the stock level of a product
  So that I know how much more I could buy

  Background: product page
    Given I am on the product detail page


  Scenario: Stock left
    Given there is stock left of a product
    Then I should see an indicator of the remaining stock on the product detail page

  Scenario: No stock left
    Given there is no stock left of a product
    Then I should see an indicator of "0" on the product

  Scenario: No stock left - hover
    Given there is no stock left of a product
    When I hover over the product
    Then I should see a message saying there is no more stock

