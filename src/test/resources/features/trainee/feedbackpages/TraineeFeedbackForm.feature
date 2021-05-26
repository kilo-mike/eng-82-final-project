Feature: Viewing feedback
Scenario: The Trainee wants to view a specific week feedback form
Given I am logged in as a trainee
When I click on the feedback for week 1
Then I will only be able to see information pertaining to week 1

  Scenario: Adding comments as a trainee
    Given I am logged in as a trainee
    When I click on the feedback for week 3
    Then I am able to add a comment in the stop box
    Then I am able to add a comment in the start box
    Then I am able to add a comment in the continue box

