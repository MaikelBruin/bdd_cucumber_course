@smoke
Feature: Login and Logout
  As a user
  I want to be able to login and logout
  So that I can access and close my account

#  Scenario: Succesful login
#    Given I am on the Polteq Webshop
#    And I am on the login page
#    When I enter my credentials
#    Then I should see my user name in the header
#
#
#  Scenario: login with credentials as parameters
#    Given I am on the Polteq Webshop
#    And I am on the login page
#    When I enter my email "maikel.bruin@polteq.com" and password "bootcamp"
#    Then I should see my user name "Maikel Bruin" in the header


  Scenario Outline: Create new account with email "<email>"
    Given I am on the Polteq Webshop
    And I am on the authentication page
    When I create a new account with email "<email>"
    Then I should see whether the email is "<valid>"

    Examples:
    |email            |valid    |
    |@polteq.com      |invalid  |
    |jenaam@polteq    |invalid  |
    |jenaam@polteq.com|valid    |
