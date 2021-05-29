Feature: User Story 54
  Scenario: A new user is prompted to change their password

    Given I am logged in as a trainer

    And I have created a new trainee profile for "Alasdair" "Malcolm" within the group "Engineering 82"

    And The trainer logs out

    When I am logged in as a trainee, non-submitting

    Then They are prompted to change the default Password