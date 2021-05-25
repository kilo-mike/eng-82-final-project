Feature: Being able to login

  Scenario:  Admin login in from login page
    Given I am on the login page as a "admin"
    When I type the username
    And I type the password
    And I click sign in as an admin
    Then I should be directed to the admin homepage

  Scenario: Trainee login in from login page
    Given I am on the login page as a "trainee"
    When I type the username
    And I type the password
    And I click sign in as a trainee
    Then I should be directed to the trainee homepage

  Scenario: Trainer login from login page
    Given I am on the login page as a "trainer"
    When I type the username
    And I type the password
    And I click sign in as a trainer
    Then I should be directed to the trainer homepage

  Scenario: Admin login from login page with invalid username and password(inc @)
    Given I am on the login page as a "admin"
    When I type the wrong username "username@edbhdhbdh"
    And I type the wrong password "dvwhgdvhjw"
    And I click sign in as an admin
    Then I should see invalid username or password message

  Scenario: Admin login from login page with invalid username and password(not inc @)
    Given I am on the login page as a "admin"
    When I type the wrong username "username"
    And I type the wrong password "dvwhgdvhjw"
    And I click sign in as an admin
    Then I should see a please include @ message

  Scenario: Admin login from login page with invalid username and valid password(inc @)
    Given I am on the login page as a "admin"
    When I type the wrong username "admin@whbdhwhjd"
    And I type the password
    And I click sign in as an admin
    Then I should see invalid username or password message

  Scenario: Admin login from login page with valid username and invalid password
    Given I am on the login page as a "admin"
    When I type the username
    And I type the wrong password "dvwhgdvhjw"
    And I click sign in as an admin
    Then I should see invalid username or password message



