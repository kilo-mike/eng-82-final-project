Feature:

  Scenario: The admin is logged in and navigates between the admin profile, admin home page and competencies page

    Given I am logged in as an "admin"

    When I click on "admin" home page button

    Then I go to the "admin "home page
