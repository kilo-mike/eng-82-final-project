Feature: Being able to login
@LoginTests
  @OtherTests
  Scenario:  Admin login in from login page
    Given I am on the login page as a "admin"
    When I type the username
    And I type the password
    And I click sign in as an admin
    Then I should be directed to the admin homepage
  @LoginTests
  @OtherTests
  Scenario: Trainee login in from login page
    Given I am on the login page as a "trainee"
    When I type the username
    And I type the password
    And I click sign in as a trainee
    Then I should be directed to the trainee homepage
  @LoginTests
  @OtherTests
  Scenario: Trainer login from login page
    Given I am on the login page as a "trainer"
    When I type the username
    And I type the password
    And I click sign in as a trainer
    Then I should be directed to the trainer homepage
  @LoginTests
  @OtherTests
  Scenario: Admin login from login page with invalid username and password(inc @)
    Given I am on the login page as a "admin"
    When I type the wrong username "username@edbhdhbdh"
    And I type the wrong password "dvwhgdvhjw"
    And I click sign in as an admin
    Then I should see invalid username or password message
  @LoginTests
  @OtherTests
  Scenario: Admin login from login page with invalid username and password(not inc @)
    Given I am on the login page as a "admin"
    When I type the wrong username "username"
    And I type the wrong password "dvwhgdvhjw"
    And I click sign in as an admin
    Then I should see a please include @ message
  @LoginTests
  @OtherTests
  Scenario: Admin login from login page with invalid username and valid password(inc @)
    Given I am on the login page as a "admin"
    When I type the wrong username "admin@whbdhwhjd"
    And I type the password
    And I click sign in as an admin
    Then I should see invalid username or password message
  @LoginTests
  @OtherTests
  Scenario: Admin login from login page with valid username and invalid password
    Given I am on the login page as a "admin"
    When I type the username
    And I type the wrong password "dvwhgdvhjw"
    And I click sign in as an admin
    Then I should see invalid username or password message



