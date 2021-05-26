Feature: Logged on to trainee and being able to view the data on the homepage
  Scenario: Viewing trainer, stream and group info

    Given I am logged in as a trainee
    When I am on the homepage
    Then I should see the stream info
    Then I should see the group info
    Then I should see the trainer info


  Scenario: viewing list of feedback

    Given I am logged in as a trainee
    When I am on the homepage
    Then I should see a selectable list of all the 1-1 sheets from previous weeks

  Scenario: The Trainee wants to see if their feedback from is in progress or late

    Given I am logged in as a trainee
    When I am on the homepage
    Then I will be able to see the status of my feedback form using the traffic light

