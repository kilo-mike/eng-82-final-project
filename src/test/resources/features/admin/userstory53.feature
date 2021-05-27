Feature: The navigation within the admin portal

  Scenario: The admin is logged in and navigates to the home page

    Given I am logged in as an "admin"

    When I click on "admin" home page button

    Then I am on the "admin" home page

  Scenario: The admin is logged in and navigates to the profile page

    Given I am logged in as an "admin"

    When I click on "admin" profile page button

    Then I am on the "admin" profile page

  Scenario: The admin is logged in and navigates to the competencies page

    Given I am logged in as an "admin"

    When I click on the competencies page button as an "admin"

    Then I am on the competencies page as an "admin"

  Scenario: The admin is logged in and navigates from the profile page to the competencies page

    Given I am logged in as an "admin"

    And I click on "admin" profile page button

    When I click on the competencies page button as an "admin"

    Then I am on the competencies page as an "admin"

  Scenario: The admin is logged in and navigates from the competencies page to the home page

    Given I am logged in as an "admin"

    And I click on the competencies page button as an "admin"

    When I click on "admin" home page button

    Then I am on the "admin" home page

  Scenario:  The admin is logged in and navigates from the competencies page to the profile page

    Given I am logged in as an "admin"

    And I click on the competencies page button as an "admin"

    When I click on "admin" profile page button

    Then I am on the "admin" profile page