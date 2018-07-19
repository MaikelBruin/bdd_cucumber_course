Feature: Authentication
  As a user
  I want to do awesome shit
  So that I can authenticate shit


  Background:
    Given I am on the Polteq Webshop
    And I am on the authentication page

    Scenario Outline: Logging in with email "<email>"
      When I enter my email "<email>" and password "<password>"
      Then I should see my user name "<username>" in the header

      Examples:
      |email                        |password     |username     |
      |tester@test.com              |1qazxsw2     |tester test  |
      |test@guru.com                |asdfghjk     |Test guru    |
      |heavylifter@feelthepain.com  |xsw21qaz     |Nope noper   |
      |bdd@cucumber.com             |zaq12wsx     |Cukes Runner |




    Scenario Outline: Create new account with email "<email>"
      When I create a new account with email "<email>"
      Then I should see whether the email is "<valid>"

      Examples:
        |email            |valid    |
        |@polteq.com      |invalid  |
        |jenaam@polteq    |invalid  |
        |jenaam@polteq.com|valid    |