Feature: User Story 54
  Scenario: A new user is prompted to change their password

    Given I am logged in as an "trainer"

    And I have created a new trainee profile for "Alasdair" "Malcolm" within the group "Engineering 82"

    And The trainer logs out

    When The trainee signs in

    Then They are prompted to change the default Password