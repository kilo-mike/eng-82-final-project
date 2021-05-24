Feature:
  Scenario: Admin logged in and adds trainers to the system

    Given I am on the admin homepage

    When I click add trainer And add a trainer's details AND I click add new trainer

    Then trainer should be added