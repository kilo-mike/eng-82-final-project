Feature: Viewing feedback
Scenario: The Trainee wants to view a specific week feedback form
Given I am logged in as a trainee
When I click on the feedback for week 1
Then I will only be able to see information pertaining to week 1

  Scenario: Adding comments as a trainee
    Given I am logged in as a trainee
    When I click on the feedback for week 3
    Then I am able to add a comment in the stop box
    And I am able to add a comment in the start box
    And I am able to add a comment in the continue box

  Scenario: The Trainee completed a feedback form and types a comment on the completed feedback form
    Given  I am logged in as a trainee
    And I am viewing a feedback form that is completed
    When The Trainee types into the comment section
    Then The Trainee will be unable to add a new comment to the stop box as the trainee is locked out of editing after completion
    And The Trainee will be unable to add a new comment to the start box as the trainee is locked out of editing after completion
    And The Trainee will be unable to add a new comment to the continue box as the trainee is locked out of editing after completion

  Scenario: The Trainee has completed and wants to submit their feedback from
    Given  I am logged in as a trainee
    And I click on the feedback for week 3
    And I have filled out the trainee feedback form
    When I click the submit button
    Then I should see the form successfully submitted



