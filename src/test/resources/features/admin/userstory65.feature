Feature:
  Scenario: Logged in as admin and changes the existing trainer details

    Given I am on the admin home page

    When I edit trainer details AND I click on the save button

    Then trainer profile is updated