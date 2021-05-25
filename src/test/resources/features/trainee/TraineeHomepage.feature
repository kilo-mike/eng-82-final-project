Feature:
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