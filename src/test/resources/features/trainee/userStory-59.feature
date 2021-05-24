Scenario: The late notifications

Given I am logged in as a trainee and have not completed my form

When The end of thursday passes

Then I will be prompted to fill it in on next login.