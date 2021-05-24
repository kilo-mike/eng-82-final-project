Feature:
  Scenario: The user on the home page logs in with incorrect credentials

    Given I am on the home page

    When I click sign in

    Then I should be displayed an error page