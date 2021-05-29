Feature: Logged on to trainee and being able to view the data on the homepage
  @TraineeTests
    @TraineeHomepageTests
  Scenario: Viewing trainer, stream and group info

    Given I am logged in as a trainee, non-submitting
    When I am on the homepage
    Then I should see the stream info for "Java Dev"
    Then I should see the group info for "Engineering 82"
    Then I should see the trainer info for "Astha Shaw"

  @TraineeTests
  @TraineeHomepageTests
  Scenario: viewing list of feedback

    Given I am logged in as a trainee, non-submitting
    When I am on the homepage
    Then I should see a selectable list of all the 1-1 sheets from previous weeks
  @TraineeTests
  @TraineeHomepageTests
  Scenario: The Trainee wants to see if their feedback from is in progress or late

    Given I am logged in as a trainee, non-submitting
    When I am on the homepage
    Then I will be able to see the status of my feedback form using the traffic light
  @TraineeTests
  @TraineeHomepageTests
  Scenario: The late notifications

    Given I am logged in as a trainee, non-submitting
    And I have not submitted my form
    When The end of thursday passes
    Then The traffic light will turn red