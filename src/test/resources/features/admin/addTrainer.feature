Feature:Being able to manage trainers

  Scenario: Admin logged in and adds trainers to the system

    Given I am on the admin homepage
    When I click add trainer
    And I add a trainer firstname "Yakooob"
    And I add a trainer lastname "Matyjewicz"
    And I select trainer group "No Group"
    And I click add new trainer
    Then Trainer should be visible on list of trainers