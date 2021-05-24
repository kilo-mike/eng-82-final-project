Feature: Being able to login
  Scenario:  Admin logging in from login page

    Given I am on the login page

    When I type the admin username
    And admin password
    And I click sign in

    Then I should be directed to the admin homepage