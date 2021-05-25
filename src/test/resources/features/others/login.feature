Feature: Being able to login

  Scenario:  Admin logging in from login page

    Given I am on the login page as a "admin"
    When I type the username
    And I type the password
    And I click sign in as an admin
    Then I should be directed to the admin homepage

  Scenario: Trainee logging in from login page
    Given I am on the login page as a "trainee"
    When I type the username
    And I type the password
    And I click sign in as a trainee
    Then I should be directed to the trainee homepage

  Scenario: Trainee logging in from login page
    Given I am on the login page as a "trainer"
    When I type the username
    And I type the password
    And I click sign in as a trainer
    Then I should be directed to the trainer homepage